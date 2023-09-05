package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.services.FileStreamService;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@AllArgsConstructor
@RequestMapping("/api/files")
public class FilesController {

    private final FilesManagerRepository repository;

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";
    private static final int RANGE_MAX_SIZE = 10485760; //10mb

    @GetMapping
    public ResponseEntity<Response> getFiles(@RequestParam(name = "path") String path) {
        try {
            var files = repository.getFiles(path).stream().filter(file ->
                    !file.getName().matches(HIDDEN_FILES_PREFIX)
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
            @RequestParam(name = "path", required = false) @Nullable String path,
            @RequestHeader(name = "Range", required = false) @Nullable String rangeHeader
    ) {
        try {
            var file = repository.getFileByPath(path);
            var type = MediaType.parseMediaType(Files.probeContentType(file.toPath()));
            var headers = new HttpHeaders();

            if (rangeHeader != null) {
                long[] range = getRangeByHeader(rangeHeader, file.length());
                if (range == null)
                    return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).build();

                long length = (range[1] - range[0]);
                if (length > RANGE_MAX_SIZE)
                    return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).build();

                headers.add("Content-Range", "bytes " + range[0] + "-" + range[1] + "/" + file.length());

                return ResponseEntity
                        .status(HttpStatus.PARTIAL_CONTENT)
                        .headers(headers)
                        .contentType(type)
                        .contentLength(length + 1)
                        .cacheControl(CacheControl.maxAge(Duration.ofHours(1)))
                        .body(new FileStreamService(file, range[0], range[1]));
            }

            headers.add("Accept-Ranges", "bytes");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(type)
                    .contentLength(file.length())
                    .cacheControl(CacheControl.maxAge(Duration.ofHours(1)))
                    .body(new FileStreamService(file));

        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Nullable
    private long[] getRangeByHeader(String range, long length) {
        Pattern pattern = Pattern.compile("bytes *= *(\\d*) *- *(\\d*)");
        Matcher matcher = pattern.matcher(range);

        if (!matcher.find())
            return null;

        long start = matcher.group(1).isEmpty() ? 0 : Long.parseLong(matcher.group(1));
        long end = matcher.group(2).isEmpty() ? 0 : Long.parseLong(matcher.group(2));

        if (end <= 0)
            end = start + RANGE_MAX_SIZE;

        if (start > end) {
            start = 0;
            end = RANGE_MAX_SIZE;
        }

        if (end > (length - 1))
            end = length - 1;

        if (end - start > RANGE_MAX_SIZE || end == 0)
            end = start + RANGE_MAX_SIZE;

        return new long[]{start, end};
    }

    @AllArgsConstructor
    public static class Response {
        private final @Getter List<FileModel> files;
    }
}
