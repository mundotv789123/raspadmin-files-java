package github.mundotv789123.raspadmin.services;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Optional<FileIconModel> fileIcon = getFromDatabase(file);

        if (fileIcon.isPresent()) {
            return processIconFile(fileIcon.get(), file);
        }
        
        return null;
    }

    public @Nullable File processIconFile(FileIconModel iconModel, File file) {
        if (!iconModel.isSimilar(file) && iconModel.getPathIcon() == null) {
            fileIconsRepository.delete(iconModel);
            return null;
        }
        File mainPathFile = appConfig.getMainPathFile();
        if (iconModel.getPathIcon() != null) {
            File iconFile = new File(mainPathFile, iconModel.getPathIcon());
            if (iconFile.exists()) {
                if (iconModel.getPathParent() == null) {
                    iconModel.setPathParent(file.getParent());
                    fileIconsRepository.save(iconModel);
                }
                return iconFile;
            }
            fileIconsRepository.delete(iconModel);
        }
        return null;
    }

    public void saveOnCache(File file, @Nullable File icon) {
        String filePath = getOriginalPath(file);
        String iconPath = icon == null ? null : getOriginalPath(icon);
        String parentPath = getOriginalPath(file.getParentFile());
        fileIconsRepository.save(new FileIconModel(filePath, iconPath, parentPath, file.length(), file.lastModified()));
    }

    public Map<String, String> getAllIconFromDir(String path) {
        HashMap<String, String> iconsPaths= new HashMap<>();
        List<FileIconModel> icons = fileIconsRepository.findAllByPathParent(path);

        for(FileIconModel icon:icons) {
            if (processIconFile(icon, new File(appConfig.getMainPath(), icon.getPathFile())) == null)
                continue;
            if (icon.getPathIcon() != null)
                iconsPaths.put(icon.getPathFile(), icon.getPathIcon());
        }

        return iconsPaths;
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
