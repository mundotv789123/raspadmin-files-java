package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class UpdateVideosThumbnail {

    @Value("${application.filesmanager.path:./files}")
    private String mainPath;

    @Value("${application.filesmanager.cachepath:./_cache}")
    private String cachePath;

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    private File mainPathFile;

    @PostConstruct
    public void init() {
        mainPathFile = new File(mainPath);
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void cron() {
        if (!enabled || !testFFMPEGCommand())
            return;

        generateThumbnailRecursiveFiles(mainPathFile);
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

        File cacheDir = new File(mainPathFile, cachePath);
        if (!cacheDir.exists())
            cacheDir.mkdirs();

        String videoPath = video.getCanonicalPath().substring(mainPathFile.getCanonicalPath().length());
        String thumbNameBase64 = Base64.getEncoder().withoutPadding().encodeToString(videoPath.getBytes());
        File thumbFile = new File(cacheDir, "_" + thumbNameBase64 + ".png");

        if (thumbFile.exists())
            return;

        runFFMPEGCommand(video, thumbFile);
    }

    private boolean testFFMPEGCommand() {
        try {
            Runtime.getRuntime().exec("ffmpeg --help");
            return true;
        } catch (IOException ex) {
            log.error(ex);
        }
        return false;
    }

    private void runFFMPEGCommand(File inputFile, File outputFile) throws IOException, InterruptedException{
        String[] commandArgs = new String[] { 
            "ffmpeg", "-n", "-i", inputFile.getCanonicalPath(), "-vf", "scale=512:-1", "-ss", "00:05", "-vframes", "1", outputFile.getCanonicalPath()
        };

        log.info("Generating thumbnail File:" + inputFile.getCanonicalPath() + " To: " + outputFile.getCanonicalPath());

        Process process = Runtime.getRuntime().exec(commandArgs);
        process.waitFor();
        
        if (process.exitValue() != 0) 
            log.error("Error: " + process.exitValue()+ " - " + new String(process.getErrorStream().readAllBytes()));
    }
}
