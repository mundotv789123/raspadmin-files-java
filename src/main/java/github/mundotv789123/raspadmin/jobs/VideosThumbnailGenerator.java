package github.mundotv789123.raspadmin.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.jobs.icons.IconGenerator;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.repositories.FilesRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class VideosThumbnailGenerator {

    @Value("${application.videos.thumbnail:false}")
    private boolean enabled;

    @Value("${application.videos.thumbnail.width:512}")
    private Integer width;

    private final AppConfig config;
    private final FilesHelper filesHelper;
    private final FilesRepository filesRepository;

    public VideosThumbnailGenerator(AppConfig config, FilesHelper filesHelper, FilesRepository filesRepository) {
        this.config = config;
        this.filesHelper = filesHelper;
        this.filesRepository = filesRepository;
    }

    @Scheduled(cron = "${application.videos.thumbnail.cron:0 */15 * * * *}")
    public void cron() {
        if (!enabled)
            return;

        log.info("Starting generate icons");
        generateThumbnailRecursiveFiles(config.getMainPathFile());
        log.info("Finished generate icons");
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

    public void generateThumbnail(File file) throws IOException, InterruptedException {
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null)
            return;

        File cacheDir = new File(config.getMainPathFile(), config.getCachePath());
        if (!cacheDir.exists())
            cacheDir.mkdirs();

        String path = filesHelper.getOriginalPath(file);
        Optional<FileModel> fileOptional = filesRepository.findByFilePath(path);

        FileModel fileModel;
        if (fileOptional.isPresent())
            fileModel = fileOptional.get();
        else {
            fileModel = filesHelper.convertFileToFileModel(file);
            filesRepository.save(fileModel);
        }

        if (!fileModel.isGenerateIcon()) {
            if (fileModel.getIconPath() == null || new File(config.getMainPathFile(), fileModel.getIconPath()).exists()) {
                return;
            }
            fileModel.setGenerateIcon();
            filesRepository.save(fileModel);
        }

        Optional<IconGenerator> iconGenerator = IconGenerator.getIconGenerator(mimeType, width);
        if (!iconGenerator.isPresent())
            return;

        File thumbFile = new File(cacheDir, "_" + UUID.randomUUID().toString() + ".jpg");
        if(!iconGenerator.get().generateIcon(file, thumbFile)) {
            fileModel.setIconPath(null);
            log.error(thumbFile.getName() + " not generated for file: " + file.getName() + ", dont saved on cache");
        } else {
            fileModel.setIconPath(thumbFile.exists() ? filesHelper.getOriginalPath(thumbFile) : null);
            log.info(fileModel.getId()+" "+thumbFile.getName() + " saved on cache");
        }
        
        filesRepository.save(fileModel);
    }
}
