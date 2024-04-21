package github.mundotv789123.raspadmin.services;

import java.io.File;
import java.util.Optional;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileIconModel;
import github.mundotv789123.raspadmin.repositories.FileIconsRepository;
import jakarta.annotation.Nullable;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service

public class FileIconService {

    private final AppConfig appConfig;
    private final FileIconsRepository fileIconsRepository;

    public FileIconService(FileIconsRepository fileIconsRepository, AppConfig appConfig) {
        this.fileIconsRepository = fileIconsRepository;
        this.appConfig = appConfig;
    }

    public @Nullable File getFileIcon(File file) {
        File icon = getFromCache(file);
        if (icon != null)
            return icon;
            
        if (file.isDirectory())
            icon = searchFileRegex(file, "^_icon\\.(png|jpe?g|svg|webp)$", null);
        else
            icon = searchFileRegex(file.getParentFile(), "^.*\\.(png|jpe?g|svg|webp)$", "_" + file.getName());

        if (icon != null)
            saveOnCache(file, icon);

        return icon;
    }

    public Optional<FileIconModel> getFromDatabase(File file) { 
        String path = getOriginalPath(file);
        return fileIconsRepository.findByPathFile(path);
    }

    public @Nullable File getFromCache(File file) {
        File mainPathFile = appConfig.getMainPathFile();
        Optional<FileIconModel> fileIcon = getFromDatabase(file);

        if (fileIcon.isPresent() && fileIcon.get().getPathIcon() != null) {
            File iconFile = new File(mainPathFile, fileIcon.get().getPathIcon());
            if (iconFile.exists())
                return iconFile;

            fileIconsRepository.delete(fileIcon.get());
        }
        
        return null;
    }

    public void saveOnCache(File file, @Nullable File icon) {
        String filePath = getOriginalPath(file);
        String iconPath = icon == null ? null : getOriginalPath(icon);
        fileIconsRepository.save(new FileIconModel(filePath, iconPath, file.length(), file.lastModified()));
    }

    private @Nullable File searchFileRegex(File dir, String regex, @Nullable String startsWith) {
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

    public String getOriginalPath(File file) {
        try {
            return file.getCanonicalPath().substring(appConfig.getMainPathFile().getCanonicalPath().length());
        } catch (Exception ex) {
            log.error(ex);
        }
        return null;
    }
}
