package github.mundotv789123.raspadmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileModel;


@Service
public class FilesHelper {

    private final AppConfig appConfig;

    public FilesHelper(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public String getOriginalPath(File file) throws IOException {
        String path = file.getCanonicalPath().substring(appConfig.getMainPathFile().getCanonicalPath().length());
        return path.isEmpty() ? "/" : path;
    }

    public String getFileType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }

    public FileModel convertFileToFileModel(File file) throws IOException {
        String originalPath = getOriginalPath(file);
        String originalParentPath = getOriginalPath(file.getParentFile());
        FileModel fileModel = new FileModel(file.getName(), originalPath, originalParentPath);
        updateFileModel(fileModel, file);
        return fileModel;
    }

    public void updateFileModel(FileModel fileModel, File file) throws IOException {
        fileModel.setType(getFileType(file));

        fileModel.setSize(file.length());
        fileModel.setDir(file.isDirectory());

        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(file.lastModified());
        fileModel.setUpdatedAt(calendar);

        fileModel.setGenerateIcon();
    }

    public boolean isSimilar(FileModel fileModel, File file) throws IOException {
        if (fileModel.isDir())
            return true;
        if (fileModel.getSize() != file.length())
            return false;
        if (fileModel.getUpdatedAt().getTimeInMillis() == file.lastModified())
            return false;
        
        if (fileModel.getType() != null && !fileModel.getType().equals(getFileType(file)))
            return false;

        return true;
    }

    public boolean FileIsInMainDir(File file) throws IOException {
        return file.getCanonicalPath().startsWith(appConfig.getMainPathFile().getCanonicalPath());
    }
}
