package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.messages.responses.FilesResponse;
import github.mundotv789123.raspadmin.models.messages.responses.StreamingPartialResponseBody;
import github.mundotv789123.raspadmin.services.app.FilesAppService;
import github.mundotv789123.raspadmin.services.converters.RangeConverter;
import github.mundotv789123.raspadmin.services.converters.RangeConverter.RangeResponse;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FilesController {
    @Value("${application.storange.cache.days:7}")
    private long cacheDays;

    private final FilesAppService filesAppService;
    private final RangeConverter rangeConverter;

    @GetMapping
    public ResponseEntity<FilesResponse> getFiles(@RequestParam(required = false) @Nullable String path) throws IOException {
        log.info(path);
        var files = filesAppService.getFiles(path);
        return ResponseEntity.ok(files);
    }

    @GetMapping("open")
    public ResponseEntity<StreamingPartialResponseBody> openFile(
        @RequestParam(required = true) String path,
        @RequestHeader(name = "Range", required = false) @Nullable String rangeHeader
    )  throws IOException  {
        RangeResponse range = rangeHeader == null ? null : rangeConverter.convertFromStringHeader(rangeHeader);
        var response = filesAppService.openFile(path, range);

        return buildPartialResponse(response);
    }

    private ResponseEntity<StreamingPartialResponseBody> buildPartialResponse(StreamingPartialResponseBody streamingResponse) throws IOException {
        Duration cacheDuration = Duration.ofDays(cacheDays);
        if (cacheDuration == null)
            throw new NullPointerException();

        BodyBuilder response;
        if (streamingResponse.isPartialFile()) {
            response = ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentLength(streamingResponse.getRange().length() + 1);
        } else {
            response = ResponseEntity.ok();
        }
        response.cacheControl(CacheControl.maxAge(cacheDuration));

        File file = streamingResponse.getFile();
        String typeString = Files.probeContentType(file.toPath());
        MediaType type = typeString != null ? MediaType.parseMediaType(typeString) : null;
        if (type != null)
            response.contentType(type);

        var headers = prepareRangeHeaders(streamingResponse.getRange(), file.length());
        return response.headers(headers).body(streamingResponse);
    }

    private HttpHeaders prepareRangeHeaders(@Nullable RangeResponse range, long length) {
        var headers = new HttpHeaders();
        if (range != null) {
            headers.add("Content-Range", "bytes " + range.start() + "-" + range.end() + "/" + length);
        } else {
            headers.add("Accept-Ranges", "bytes");
        }
        return headers;
    }
}
