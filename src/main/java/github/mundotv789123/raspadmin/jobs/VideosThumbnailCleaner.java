package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileIconModel;
import github.mundotv789123.raspadmin.repositories.FileIconsRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class VideosThumbnailCleaner {

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    private final AppConfig config;
    private final FileIconsRepository fileIconsRepository;

    public VideosThumbnailCleaner(AppConfig config, FileIconsRepository fileIconsRepository) {
        this.config = config;
        this.fileIconsRepository = fileIconsRepository;
    }

    @Scheduled(cron = "${application.videos.thumbnail.cleancron:0 0 */24 * * *}")
    public void cron() {
        if (!enabled)
            return;

        clearOrphanThumbnails();
    }

    public void clearOrphanThumbnails() {
        File mainPathFile = config.getMainPathFile();
        File cacheDir = new File(mainPathFile, config.getCachePath());
        if (!cacheDir.exists() || cacheDir.isFile())
            return;

        for (File file : cacheDir.listFiles()) {
            try {
                String filePath = file.getCanonicalPath().substring(mainPathFile.getCanonicalPath().length());
                Optional<FileIconModel> fileIcon = fileIconsRepository.findByPathIcon(filePath);
                if (!fileIcon.isPresent()) {
                    file.delete();
                    log.info("File " + filePath + " not found on cache database");
                } else {
                    File mainFile = new File(mainPathFile, fileIcon.get().getPathFile());
                    if (mainFile.exists()) {
                        if (isSimilar(fileIcon.get(), mainFile))
                            continue;
                    }
                    log.info("File icon of " + filePath + " is inconsistent, deleting...");
                    file.delete();
                    fileIconsRepository.delete(fileIcon.get());
                }
            } catch (IOException ex) {
                log.error(ex);
                continue;
            }
        }
    }

    public boolean isSimilar(FileIconModel fileModel, File file) {
        return (fileModel.getSize().equals(file.length())) && fileModel.getLastModified().equals(file.lastModified());
    }
}
