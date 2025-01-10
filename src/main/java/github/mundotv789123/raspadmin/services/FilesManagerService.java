package github.mundotv789123.raspadmin.services;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.messages.dto.FileDTO;
import github.mundotv789123.raspadmin.services.exceptions.InvalidOperateServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class FilesManagerService {

    private final AppConfig appConfig;
    private final FilesHelper helper;
    private final FilesService fileService;

    public Collection<FileDTO> getFiles(String path) throws FileNotFoundException, IOException {
        String pathFile = (path == null || path.matches("\\/*")) ? "./" : path;
        File file = getFileByPath(pathFile);
        
        return fileService.getAllFilesFromDir(file).stream().map(fileModel -> 
            FileDTO.toDTO(fileModel, !file.isDirectory())
        ).collect(Collectors.toList());
    }

    public File getFileByPath(String path) throws IOException {
        File mainPathFile = appConfig.getMainPathFile();
        if (!mainPathFile.exists() || !mainPathFile.isDirectory()) {
            throw new InvalidOperateServiceException("File " + path + " not found!", HttpStatus.NOT_FOUND);
        }

        var file = new File(mainPathFile, path);
        if (!file.exists()) {
            throw new InvalidOperateServiceException("File " + path + " not found!", HttpStatus.NOT_FOUND);
        }

        if (!helper.FileIsInMainDir(file)) {
            throw new InvalidOperateServiceException("File " + path + " not found!", HttpStatus.NOT_FOUND);
        }

        return file;
    }

    public String getDirWallpaperPath(File dir) {
        try {
            var wallpaperFile = helper.getIconOfDir(dir, "wallpaper");
            var wallpaperPath = wallpaperFile.isPresent() ? helper.getOriginalPath(wallpaperFile.get()) : null;
            return wallpaperPath;
        } catch (IOException ex) {
            return null;
        }
    }
  
}
