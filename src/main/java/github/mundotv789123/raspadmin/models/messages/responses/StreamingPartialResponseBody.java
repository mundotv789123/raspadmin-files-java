package github.mundotv789123.raspadmin.models.messages.responses;

import lombok.Getter;

import org.springframework.lang.NonNull;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import github.mundotv789123.raspadmin.services.converters.RangeConverter.RangeResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamingPartialResponseBody implements StreamingResponseBody {
    private static final int BUFFER_SIZE = 8192;

    private final @Getter File file;

    private @Getter long start = 0;
    private @Getter long end = 0;
    
    private final @Getter RangeResponse range;

    public StreamingPartialResponseBody(File file) {
        this.file = file;
        this.range = null;
    }

    public StreamingPartialResponseBody(File file, RangeResponse range) {
        this.file = file;
        this.range = range;
        
        this.start = range.start();
        this.end = range.end();
    }

    @Override
    public void writeTo(@NonNull OutputStream outputStream) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            long maxLength = getMaxLength();

            if (!isPartialFile()) {
                fileInputStream.transferTo(outputStream);
                return;
            }

            if (start > 0 && start < file.length() && fileInputStream.skip(start) <= 0) {
                return;
            }

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            try {
                long readed = 0;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    readed += length;
                    if (end > start && (readed > maxLength)) {
                        int len = (int) (readed - maxLength);
                        outputStream.write(buffer, 0, len);
                        break;
                    }

                    outputStream.write(buffer, 0, length);
                }
            } catch(ClientAbortException ex) {
            }
            fileInputStream.close();
        }
    }

    public long getMaxLength() {
        return end > start ? (end - start) + 1 : 0;
    }

    public boolean isPartialFile() {
        return getMaxLength() > 0;
    }
}
