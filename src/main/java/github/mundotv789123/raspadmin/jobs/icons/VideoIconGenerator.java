package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class VideoIconGenerator extends EmbedIconGenerator {

    public VideoIconGenerator(int width) {
        super(width);
    }

    @Override
    public boolean generateIcon(File file, File icon) throws IOException, InterruptedException {
        if (super.generateIcon(file, icon))
            return true;

        String input = file.getCanonicalPath();
        String output = icon.getCanonicalPath();

        log.info("Generating thumbnail File: '" + input + "' To: '" + output + "'");
        Process process = generateNewIcon(input, output, Integer.toString(width));
        if (process.exitValue() != 0) {
            log.error("Error: " + process.exitValue()+ " - " + new String(process.getErrorStream().readAllBytes()));
            return false;
        }

        return true;
    }

    private Process generateNewIcon(String input, String output, String width) throws IOException, InterruptedException {
        Process process = runCommand("ffmpegthumbnailer", "-i", input, "-o", output, "-s", width);
        return process;
    }
    
}
