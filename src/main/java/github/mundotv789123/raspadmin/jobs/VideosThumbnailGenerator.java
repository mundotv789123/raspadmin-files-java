package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.services.FileIconService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class VideosThumbnailGenerator {

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    @Value("${application.videos.thumbnail.width:512}")
    private Integer width;

    private final AppConfig config;
    private final FileIconService fileIconService;

    public VideosThumbnailGenerator(AppConfig config, FileIconService fileIconService) {
        this.config = config;
        this.fileIconService = fileIconService;
    }

    @Scheduled(cron = "${application.videos.thumbnail.cron:0 */15 * * * *}")
    public void cron() {
        if (!enabled || !testFFMPEGCommand())
            return;

        generateThumbnailRecursiveFiles(config.getMainPathFile());
    }

    public void generateThumbnailRecursiveFiles(File dir) {
        if (!dir.isDirectory())
            return;

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                generateThumbnailRecursiveFiles(file);
                continue;
            }
            try {
                generateThumbnail(file);
            } catch (IOException | InterruptedException ex) {
                log.error(ex);
            }
        }
    }

    public void generateThumbnail(File video) throws IOException, InterruptedException {
        String mimeType = Files.probeContentType(video.toPath());
        if (mimeType == null || !mimeType.matches("video/(mp4|mkv|webm)"))
            return;

        File cacheDir = new File(config.getMainPathFile(), config.getCachePath());
        if (!cacheDir.exists())
            cacheDir.mkdirs();

        File thumbFile = fileIconService.getFromCache(video);
        if (thumbFile != null)
            return;

        thumbFile = new File(cacheDir, "_"+UUID.randomUUID().toString()+".jpg");
        runFFMPEGCommand(video, thumbFile);
        if (thumbFile.exists())
            fileIconService.saveOnCache(video, thumbFile);
        else 
            log.error(thumbFile.getName() + " not generated, dont saved on cache");
    }

    private boolean testFFMPEGCommand() {
        try {
            String[] commandHelp = { "ffmpegthumbnailer", "--help" };
            Runtime.getRuntime().exec(commandHelp);
            return true;
        } catch (IOException ex) {
            log.error(ex);
        }
        return false;
    }

    private void runFFMPEGCommand(File inputFile, File outputFile) throws IOException, InterruptedException {
        String inputFilePath = inputFile.getCanonicalPath();
        String outputFilePath = outputFile.getCanonicalPath();

        String[] commandArgs = new String[] { 
            "ffmpegthumbnailer", "-i", inputFilePath, "-o", outputFilePath, "-s", width.toString()
        };

        log.info("Generating thumbnail File: '" + inputFilePath + "' To: '" + outputFilePath + "'");

        Process process = Runtime.getRuntime().exec(commandArgs);
        process.waitFor();
        
        if (process.exitValue() != 0) 
            log.error("Error: " + process.exitValue()+ " - " + new String(process.getErrorStream().readAllBytes()));
    }
}
