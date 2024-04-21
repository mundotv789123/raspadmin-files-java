package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public abstract class IconGenerator {
    public abstract void generateIcon(File file, File icon) throws IOException, InterruptedException;

    public static Optional<IconGenerator> getIconGenerator(String mimeType) {
        if (mimeType.matches("video/(mp4|mkv|webm)"))
            return Optional.of(new VideoIconGenerator());

        return Optional.empty();
    }
}
