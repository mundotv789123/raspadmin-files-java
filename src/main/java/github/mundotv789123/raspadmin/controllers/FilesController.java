package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.dto.FilesResponseDTO;
import github.mundotv789123.raspadmin.services.FileStreamService;
import github.mundotv789123.raspadmin.services.FilesManagerService;
import github.mundotv789123.raspadmin.services.RangeConverterService;
import jakarta.annotation.Nullable;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

@Log4j2
@RestController
@RequestMapping("/api/files")
public class FilesController {

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";

    @Value("${application.storange.cache.days:7}")
    private long cacheDays;

    private final FilesManagerService fileService;
    private final RangeConverterService rangeService;

    public FilesController(FilesManagerService repository, RangeConverterService rangeService) {
        this.fileService = repository;
        this.rangeService = rangeService;
    }

    @GetMapping
    public ResponseEntity<FilesResponseDTO> getFiles(
        @RequestParam(name = "path", required = false) 
        @Nullable String path
    ) {
        try {
            var files = fileService.getFiles(path);
            var filesModel = files.stream()
                .filter(file -> file.isOpen() || !file.getName().matches(HIDDEN_FILES_PREFIX)).toList();

            log.info("Listed files from: " + path);
            return ResponseEntity.ok(new FilesResponseDTO(filesModel));
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            log.error("Error whiling list files: " + path, ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("open")
    public ResponseEntity<StreamingResponseBody> openFile(
        @RequestParam(name = "path", required = true) String path,
        @RequestHeader(name = "Range", required = false) @Nullable String rangeHeader
    ) {
        try {
            var headers = new HttpHeaders();
            File file = fileService.getFileByPath(path);

            BodyBuilder response = getBodyBuilderOfFile(file, rangeHeader != null);

            if (rangeHeader != null) {
                long[] range = rangeService.getRangeByHeader(rangeHeader, file.length());
                long length = (range[1] - range[0]);

                log.info("Opened file range: (" + range[0] + "-" + range[1] + ") path:" + path);
                headers.add("Content-Range", "bytes " + range[0] + "-" + range[1] + "/" + file.length());
                return response
                    .contentLength(length + 1)
                    .headers(headers)
                    .body(new FileStreamService(file, range[0], range[1]));
            }

            log.info("Opened file: " + path);
            headers.add("Accept-Ranges", "bytes");
            return response
                .contentLength(file.length())
                .headers(headers)
                .body(new FileStreamService(file));

        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (IndexOutOfBoundsException ex) {
            log.error("Error whiling open file: " + path, ex);
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).build();
        } catch (Exception ex) {
            log.error("Error whiling open file: " + path, ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    private BodyBuilder getBodyBuilderOfFile(File file, boolean partial) throws IOException {
        String typeString = Files.probeContentType(file.toPath());

        Duration cacheDuration = Duration.ofDays(cacheDays);
        if (cacheDuration == null)
            throw new NullPointerException();

        BodyBuilder response = partial ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.ok();

        response.cacheControl(CacheControl.maxAge(cacheDuration));

        MediaType type = typeString != null ? MediaType.parseMediaType(typeString) : null;
        if (type != null)
            response.contentType(type);

        return response;
    }
}
