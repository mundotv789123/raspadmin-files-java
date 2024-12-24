package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.dto.FilesResponseDTO;
import github.mundotv789123.raspadmin.services.FilesManagerService;
import github.mundotv789123.raspadmin.services.stream.FileStreamService;
import github.mundotv789123.raspadmin.services.stream.RangeConverterService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FilesController {

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";

    @Value("${application.storange.cache.days:7}")
    private long cacheDays;

    private final FilesManagerService fileService;
    private final RangeConverterService rangeService;

    @GetMapping
    public ResponseEntity<FilesResponseDTO> getFiles(@RequestParam(required = false) @Nullable String path) throws IOException {
        var files = fileService.getFiles(path);
        var filesModel = files.stream().filter(file -> file.isOpen() || !file.getName().matches(HIDDEN_FILES_PREFIX)).toList();
        log.info("Listed files from: " + path);
        return ResponseEntity.ok(new FilesResponseDTO(filesModel));
    }

    @GetMapping("open")
    public ResponseEntity<StreamingResponseBody> openFile(
        @RequestParam(required = true) String path,
        @RequestHeader(name = "Range", required = false) @Nullable String rangeHeader
    )  throws IOException  {
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
        return response.contentLength(file.length()).headers(headers).body(new FileStreamService(file));
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
