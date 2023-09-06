package github.mundotv789123.raspadmin.services;

import lombok.Getter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
            if (start > 0 && start < file.length()) {
                in.skip(start);
            }

            long maxLength = (end - start) + 1;

            byte[] buffer = new byte[1024];
            int length;

            long readed = 0;
            while ((length = in.read(buffer)) > 0) {
                readed += readed;
                if (end > start && (readed > maxLength))
                    length = (int) (readed - maxLength);

                outputStream.write(buffer, 0, length);
            }
        }
    }

}
