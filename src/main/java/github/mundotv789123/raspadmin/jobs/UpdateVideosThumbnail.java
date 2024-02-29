package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.micrometer.common.lang.Nullable;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class UpdateVideosThumbnail {

    @Value("${application.filesmanager.path:./files}")
    private String mainPath;

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    @Scheduled(cron = "*/15 * * * * *")
    public void teste() {
        if (!enabled)
            return;

        try {
            Runtime.getRuntime().exec("ffmpeg --help");
            getAllVideos(null);
        } catch (IOException | InterruptedException ex) {
            log.error(ex);
        }
    }

    public void getAllVideos(@Nullable File dir) throws IOException, InterruptedException {
        if (dir == null)
            dir = new File(mainPath);

        if (!dir.isDirectory())
            return;

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                getAllVideos(file);
                continue;
            }
            String mimeType = Files.probeContentType(file.toPath());

            if (mimeType.contains("video"))
                generateThumbnail(file);
        }
    }

    public void generateThumbnail(File video) throws IOException, InterruptedException {
        File thumbFile = new File(video.getParent(), "_" + video.getName() + ".png");
        if (thumbFile.exists())
            return;

        String[] commandArgs = new String[] { 
            "ffmpeg", "-n", "-i", video.getCanonicalPath(), "-vf", "scale=512:-1", "-ss", "00:00", "-vframes", "1", thumbFile.getCanonicalPath()
        };

        Process process = Runtime.getRuntime().exec(commandArgs);
        process.waitFor();
        
        if (process.exitValue() != 0) 
            log.error("Error: " + process.exitValue()+ " - " + new String(process.getErrorStream().readAllBytes()));
    }
}
