package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.dto.FilesResponseDTO;
import github.mundotv789123.raspadmin.services.FileStreamService;
import github.mundotv789123.raspadmin.services.RangeConverterService;
import jakarta.annotation.Nullable;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import github.mundotv789123.raspadmin.repositories.FilesManagerRepository;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.time.Duration;

@Log4j2
@RestController
@RequestMapping("/api/files")
public class FilesController {

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";

    @Value("${application.storange.cache.days:7}")
    private long cacheDays;

    private final FilesManagerRepository repository;
    private final RangeConverterService rangeService;

    public FilesController(FilesManagerRepository repository, RangeConverterService rangeService) {
        this.repository = repository;
        this.rangeService = rangeService;
    }

    @GetMapping
    public ResponseEntity<FilesResponseDTO> getFiles(@RequestParam(name = "path", required = false) @Nullable String path) {
        try {
            var files = repository.getFiles(path).stream().filter(file ->
                file.isOpen() || !file.getName().matches(HIDDEN_FILES_PREFIX)
            ).toList();

            log.info("Listed files from: "+path);
            return ResponseEntity.ok(new FilesResponseDTO(files));
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            log.error("Error whiling list files: "+path, ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("open")
    public ResponseEntity<StreamingResponseBody> openFile(
        @RequestParam(name = "path", required = true) String path,
        @RequestHeader(name = "Range", required = false) @Nullable String rangeHeader
    ) {
        try {
            var file = repository.getFileByPath(path);
            var type = MediaType.parseMediaType(Files.probeContentType(file.toPath()));
            var headers = new HttpHeaders();

            if (rangeHeader != null) {
                long[] range = rangeService.getRangeByHeader(rangeHeader, file.length());
                long length = (range[1] - range[0]);

                log.info("Opened file range: "+path);
                headers.add("Content-Range", "bytes " + range[0] + "-" + range[1] + "/" + file.length());
                return ResponseEntity
                    .status(HttpStatus.PARTIAL_CONTENT)
                    .headers(headers)
                    .contentType(type)
                    .contentLength(length + 1)
                    .cacheControl(CacheControl.maxAge(Duration.ofDays(cacheDays)))
                    .body(new FileStreamService(file, range[0], range[1])
                );
            }

            log.info("Opened file: "+path);
            headers.add("Accept-Ranges", "bytes");
            return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(type)
                .contentLength(file.length())
                .cacheControl(CacheControl.maxAge(Duration.ofHours(1)))
                .body(new FileStreamService(file)
            );
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (IndexOutOfBoundsException ex) {
            log.error("Error whiling open file: "+path, ex);
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).build();
        } catch (Exception ex) {
            log.error("Error whiling open file: "+path, ex);
            return ResponseEntity.internalServerError().build();
        } 
    }
}
