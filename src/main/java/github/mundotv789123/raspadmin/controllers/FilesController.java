package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.services.FileStreamService;
import github.mundotv789123.raspadmin.services.RangeConverterService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import github.mundotv789123.raspadmin.repositories.FilesManagerRepository;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/files")
public class FilesController {

    private final FilesManagerRepository repository;
    private final RangeConverterService rangeService;

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";
    private static final int RANGE_MAX_SIZE = 10485760; //10mb

    @GetMapping
    public ResponseEntity<Response> getFiles(@RequestParam(name = "path", required = false) @Nullable String path) {
        try {
            var files = repository.getFiles(path).stream().filter(file ->
                file.isOpen() || !file.getName().matches(HIDDEN_FILES_PREFIX)
            ).toList();

            return ResponseEntity.ok(new Response(files));
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
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
                long[] range = rangeService.getRangeByHeader(rangeHeader, file.length(), RANGE_MAX_SIZE);
                long length = (range[1] - range[0]);

                headers.add("Content-Range", "bytes " + range[0] + "-" + range[1] + "/" + file.length());
                return ResponseEntity
                    .status(HttpStatus.PARTIAL_CONTENT)
                    .headers(headers)
                    .contentType(type)
                    .contentLength(length + 1)
                    .cacheControl(CacheControl.maxAge(Duration.ofHours(1)))
                    .body(new FileStreamService(file, range[0], range[1])
                );
            }

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
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        } 
    }

    @AllArgsConstructor
    public static class Response {
        private final @Getter List<FileModel> files;
    }
}
