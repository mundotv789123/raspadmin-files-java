package github.mundotv789123.raspadmin.services;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Log4j2
public class FileStreamService implements StreamingResponseBody {

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
    public void writeTo(OutputStream outputStream) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            long maxLength = end > start ? (end - start) + 1 : 0;

            if (maxLength == 0) {
                in.transferTo(outputStream);
                return;
            }

            if (start > 0 && start < file.length() && in.skip(start) <= 0) {
                return;
            }

            byte[] buffer = new byte[1024];
            int length;

            long readed = 0;
            while ((length = in.read(buffer)) > 0) {
                readed += length;
                if (end > start && (readed > maxLength)) {
                    int len = (int) (readed - maxLength);
                    outputStream.write(buffer, 0, len);
                    break;
                }

                outputStream.write(buffer, 0, length);
            }
            in.close();
        }
    }

}
