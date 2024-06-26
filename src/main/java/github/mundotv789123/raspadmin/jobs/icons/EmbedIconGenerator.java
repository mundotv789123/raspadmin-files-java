package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class EmbedIconGenerator extends IconGenerator {
    public EmbedIconGenerator(int width) {
        super(width);
    }

    public boolean generateIcon(File file, File icon) throws IOException, InterruptedException {
        String input = file.getCanonicalPath();
        String output = icon.getCanonicalPath();

        if (extractEmbedIcon(input, output).exitValue() == 0 && icon.exists()) {
            log.info("File: " + input + " constains a thumbnail embedded");
            return true;
        }

        return false;
    }

    private Process extractEmbedIcon(String input, String output) throws IOException, InterruptedException {
        Process process = runCommand("ffmpeg", "-i", input, "-map", "0:v", "-map", "-0:V", "-c", "copy", output);
        return process;
    }

}
