package github.mundotv789123.raspadmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.entities.FileEntity;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class FilesHelper {

    private final AppConfig appConfig;

    public String getOriginalPath(File file) throws IOException {
        String path = file.getCanonicalPath().substring(appConfig.getMainPathFile().getCanonicalPath().length());
        return path.isEmpty() ? "/" : path;
    }

    public String getFileType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }

    public FileEntity convertFileToFileModel(File file) throws IOException {
        String originalPath = getOriginalPath(file);
        String originalParentPath = getOriginalPath(file.getParentFile());
        FileEntity fileModel = new FileEntity(file.getName(), originalPath, originalParentPath);
        updateFileModel(fileModel, file);
        return fileModel;
    }

    public void updateFileModel(FileEntity fileModel, File file) throws IOException {
        fileModel.setType(getFileType(file));

        fileModel.setSize(file.length());
        fileModel.setDir(file.isDirectory());

        var lastModified = file.lastModified() / 1000 * 1000;
        if (lastModified > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(file.lastModified() / 1000 * 1000);
            fileModel.setUpdatedAt(calendar);
        }

        fileModel.setGenerateIcon();
    }

    public boolean isSimilar(FileEntity fileModel, File file) throws IOException {
        if (fileModel.isDir())
            return file.isDirectory() == fileModel.isDir();

        if (fileModel.getSize() != file.length()) {
            log.info("Size " + fileModel.getSize() + " != " + file.length());
            return false;
        }

        long timeSeconds = file.lastModified() / 1000 * 1000;
        if (fileModel.getUpdatedAt().getTimeInMillis() != timeSeconds) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeSeconds);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            log.info("UpdatedAt " + dateFormat.format(fileModel.getUpdatedAt().getTime()) + " != "
                    + dateFormat.format(calendar.getTime()));

            return false;
        }

        String type = getFileType(file);
        if (fileModel.getType() != null && !fileModel.getType().equals(type)) {
            log.info("Type " + fileModel.getType() + " != " + file.lastModified());
            return false;
        }

        return true;
    }

    public Optional<File> getIconOfDir(File file, String prefix) {
        return searchFileRegex(file, "^_" + prefix + "\\.(png|jpe?g|svg|webp)$");
    }

    public @Nullable Optional<File> searchFileRegex(File dir, String regex) {
        for (String fileName : dir.list()) {
            if (!fileName.matches(regex))
                continue;

            File fileIcon = new File(dir, fileName);
            if (fileIcon.isFile())
                return Optional.of(fileIcon);
        }
        return Optional.empty();
    }

    public boolean FileIsInMainDir(File file) throws IOException {
        return file.getCanonicalPath().startsWith(appConfig.getMainPathFile().getCanonicalPath());
    }
}
