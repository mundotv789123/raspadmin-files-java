package github.mundotv789123.raspadmin.repositories;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileModel;
import jakarta.annotation.Nullable;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Component
public class FilesManagerRepository {

    private final AppConfig appConfig;

    public FilesManagerRepository(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public Collection<FileModel> getFiles(String path) throws FileNotFoundException {
        String pathFile = (path == null || path.matches("\\/*")) ? "" : path;
        var file = getFileByPath(pathFile);
        
        if (!file.isDirectory())
            return List.of(FileModel.fileToModel(file, true));

        List<FileModel> files = new ArrayList<>();
        for (String fileName : file.list()) {
            var subFile = new File(file, fileName);
            var fileModel = FileModel.fileToModel(subFile);
            File fileIcon = getFileIcon(subFile);
            if (fileIcon != null) {
                try {
                    String videoPath = fileIcon.getCanonicalPath().substring(appConfig.getMainPathFile().getCanonicalPath().length());
                    fileModel.setIcon(videoPath);
                } catch (IOException ex) {
                    fileModel.setIcon(null);
                }
            }
            files.add(fileModel);
        }

        return files;
    }

    public File getFileByPath(String path) throws FileNotFoundException {
        File mainPathFile = appConfig.getMainPathFile();
        if (!mainPathFile.exists() || !mainPathFile.isDirectory())
            throw new FileNotFoundException("File " + path + "not found!");

        var file = new File(mainPathFile, path);
        if (!file.exists())
            throw new FileNotFoundException("File " + path + "not found!");

        try {
            if (!file.getCanonicalPath().startsWith(mainPathFile.getCanonicalPath()))
                throw new IOException();
        } catch (IOException ex) {
            throw new FileNotFoundException("File not found!");
        }

        return file;
    }

    public @Nullable File getFileIcon(File file) {
        if (file.isDirectory()) {
            return searchFileRegex(file, "^_icon\\.(png|jpe?g|svg|webp)$", null);
        }

        File icon = searchFileRegex(file.getParentFile(), "^.*\\.(png|jpe?g|svg|webp)$", "_" + file.getName());
        if (icon != null)
            return icon;
        
        return searchIconFromCacheDir(file);
    }

    public @Nullable File searchFileRegex(File dir, String regex, @Nullable String startsWith) {
        for (String fileName : dir.list()) {
            if (startsWith != null && !fileName.startsWith(startsWith))
                continue;

            if (!fileName.matches(regex)) 
                continue;

            File fileIcon = new File(dir, fileName);
            if (fileIcon.isFile())
                return fileIcon;
        }
        return null;
    }

    public @Nullable File searchIconFromCacheDir(File file) {
        File mainPathFile = appConfig.getMainPathFile();
        File cacheDir = new File(mainPathFile, appConfig.getCachePath());
        if (!cacheDir.exists())
            return null;

        try {
            String videoPath = file.getCanonicalPath().substring(mainPathFile.getCanonicalPath().length());
            String thumbNameBase64 = Base64.getEncoder().withoutPadding().encodeToString(videoPath.getBytes());
            thumbNameBase64 = thumbNameBase64.replace("/", "-");
            File thumbFile = new File(cacheDir, "_" + thumbNameBase64 + ".png");
            if (thumbFile.exists())
                return thumbFile;
        } catch (IOException ex) {
            return null;
        }
        
        return null;
    }
}
