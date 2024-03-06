package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.config.AppConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class VideosThumbnailCleaner {

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    private final AppConfig config;

    public VideosThumbnailCleaner(AppConfig config) {
        this.config = config;
    }

    @Scheduled(cron = "${application.videos.thumbnail.cleancron:0 0 */24 * * *}")
    public void cron() {
        if (!enabled)
            return;

        clearOrphanThumbnails();
    }

    public void clearOrphanThumbnails() {
        File cacheDir = new File(config.getMainPathFile(), config.getCachePath());
        if (!cacheDir.exists() || cacheDir.isFile())
            return;

        for (String fileName : cacheDir.list()) {
            if (!existsFileFromThumbFile(fileName)) {
                log.info("Thumbnail: " + fileName + " don't have a file, deleting...");
                new File(cacheDir, fileName).delete();
            }
        }
    }

    public boolean existsFileFromThumbFile(String fileName) {
        Pattern pattern = Pattern.compile("^_(.*)\\.png$");
        Matcher result = pattern.matcher(fileName);
        if (!result.matches())
            return true;

        String base64 = result.group(1).replace("-", "/");

        String filePath = new String(Base64.getDecoder().decode(base64));
        File file = new File(config.getMainPath(), filePath);
        return file.exists();
    }
}
