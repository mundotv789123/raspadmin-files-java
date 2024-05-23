package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.repositories.FilesRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class VideosThumbnailCleaner {

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    private final AppConfig config;
    private final FilesHelper filesHelper;
    private final FilesRepository filesRepository;

    public VideosThumbnailCleaner(AppConfig config, FilesHelper filesHelper, FilesRepository filesRepository) {
        this.config = config;
        this.filesHelper = filesHelper;
        this.filesRepository = filesRepository;
    }

    @Scheduled(cron = "${application.videos.thumbnail.cleancron:0 0 */24 * * *}")
    public void cron() {
        if (!enabled)
            return;
        log.info("Starting clean icons");
        clearOrphanThumbnails();
        log.info("Finished clean icons");
    }

    public void clearOrphanThumbnails() {
        File mainPathFile = config.getMainPathFile();
        File cacheDir = new File(mainPathFile, config.getCachePath());
        if (!cacheDir.exists() || cacheDir.isFile())
            return;

        for (File file : cacheDir.listFiles()) {
            try {
                String filePath = filesHelper.getOriginalPath(file);
                Optional<FileModel> fileOptional = filesRepository.findByIconPath(filePath);

                if (!fileOptional.isPresent()) {
                    file.delete();
                    log.info("File " + filePath + " not found on database");
                    continue;
                }

                FileModel fileModel = fileOptional.get();
                File mainFile = new File(mainPathFile, fileModel.getFilePath());

                if (!mainFile.exists()) {
                    log.info("File icon of " + filePath + " not found, deleting from database");
                    filesRepository.delete(fileModel);
                    continue;
                }

                if (filesHelper.isSimilar(fileModel, mainFile))
                    continue;
                    
                log.info("File icon of " + filePath + " is inconsistent, deleting and set to generate new icon...");
                file.delete();

                filesHelper.updateFileModel(fileModel, mainFile);
                filesRepository.save(fileModel);

            } catch (IOException ex) {
                log.error(ex);
                continue;
            }
        }
    }

}
