package github.mundotv789123.raspadmin.services;

import lombok.Getter;

import org.springframework.lang.NonNull;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileStreamService implements StreamingResponseBody {

    private static final int BUFFER_SIZE = 8192;

    private final File file;

    private @Getter long start = 0;
    private @Getter long end = 0;

    public FileStreamService(File file) {
        this.file = file;
    }

    public FileStreamService(File file, long start, long end) {
        this.file = file;
        this.start = start;
        this.end = end;
    }

    @Override
    public void writeTo(@NonNull OutputStream outputStream) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            long maxLength = end > start ? (end - start) + 1 : 0;

            if (maxLength == 0) {
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

}
