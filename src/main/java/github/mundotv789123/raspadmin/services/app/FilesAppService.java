package github.mundotv789123.raspadmin.services.app;

import github.mundotv789123.raspadmin.models.messages.responses.FilesResponse;
import github.mundotv789123.raspadmin.models.messages.responses.StreamingPartialResponseBody;
import github.mundotv789123.raspadmin.services.FilesManagerService;
import github.mundotv789123.raspadmin.services.converters.RangeConverter;
import github.mundotv789123.raspadmin.services.converters.RangeConverter.RangeResponse;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Log4j2
@Service
@RequiredArgsConstructor
public class FilesAppService {

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";

    @Value("${application.storange.cache.days:7}")
    private long cacheDays;

    private final FilesManagerService fileService;
    private final RangeConverter rangeConverter;

    public FilesResponse getFiles(@Nullable String path) throws IOException {
        var files = fileService.getFiles(path);
        var filesModel = files.stream().filter(file -> file.isOpen() || !file.getName().matches(HIDDEN_FILES_PREFIX)).toList();
        log.info("Listed files from: " + path);

        return new FilesResponse(filesModel);
    }

    public StreamingPartialResponseBody openFile(String path, @Nullable RangeResponse range)  throws IOException {
        File file = fileService.getFileByPath(path);

        if (range != null) {
            range = rangeConverter.validateRange(range, file.length());
            log.info("Opened file range: (" + range.start() + "-" + range.end() + ") path:" + path);
            return new StreamingPartialResponseBody(file, range);
        }

        log.info("Opened file: " + path);
        return new StreamingPartialResponseBody(file);
    }
}
