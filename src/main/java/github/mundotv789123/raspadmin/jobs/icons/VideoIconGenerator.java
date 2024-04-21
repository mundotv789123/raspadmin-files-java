package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class VideoIconGenerator extends IconGenerator {

    @Value("${application.videos.thumbnail.width:512}")
    private Integer width;

    @Override
    public void generateIcon(File file, File icon) throws IOException, InterruptedException {
        String input = file.getCanonicalPath();
        String output = icon.getCanonicalPath();

        if (extractEmbedIcon(input, output).exitValue() == 0 && icon.exists()) {
            log.info("File: " + input + " constains a thumbnail embedded");
            return;
        }

        log.info("Generating thumbnail File: '" + input + "' To: '" + output + "'");
        Process process = generateNewIcon(input, output, width.toString());
        if (process.exitValue() != 0)
            log.error("Error: " + process.exitValue()+ " - " + new String(process.getErrorStream().readAllBytes()));
    }

    private Process extractEmbedIcon(String input, String output) throws IOException, InterruptedException {
        Process process = runCommand("ffmpeg", "-i", input, "-map", "0:v", "-map", "-0:V", "-c", "copy", output);
        return process;
    }

    private Process generateNewIcon(String input, String output, String width) throws IOException, InterruptedException {
        Process process = runCommand("ffmpegthumbnailer", "-i", input, "-o", output, "-s", width);
        return process;
    }

    private Process runCommand(String ... command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        return process;
    }
}
