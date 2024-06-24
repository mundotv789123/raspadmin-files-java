package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;

public class AudioIconGenerator extends EmbedIconGenerator {
    public AudioIconGenerator(int width) {
        super(width);
    }

    @Override
    public boolean generateIcon(File file, File icon) throws IOException, InterruptedException {
        super.generateIcon(file, icon);
        return true;
    }
}
