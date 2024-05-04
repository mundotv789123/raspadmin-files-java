package github.mundotv789123.raspadmin.services;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.dto.FileDTO;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Log4j2
@Component
public class FilesManagerService {

    private final AppConfig appConfig;
    private final FilesHelper helper;
    private final FilesService fileService;

    public FilesManagerService(AppConfig appConfig, FilesHelper helper, FilesService fileService) {
        this.appConfig = appConfig;
        this.helper = helper;
        this.fileService = fileService;
    }

    public Collection<FileDTO> getFiles(String path) throws FileNotFoundException, IOException {
        String pathFile = (path == null || path.matches("\\/*")) ? "./" : path;
        File file = getFileByPath(pathFile);
        
        return fileService.getAllFilesFromDir(file).stream().map(fileModel -> 
            FileDTO.toDTO(fileModel, !file.isDirectory())
        ).collect(Collectors.toList());
    }

    public File getFileByPath(String path) throws FileNotFoundException {
        File mainPathFile = appConfig.getMainPathFile();
        if (!mainPathFile.exists() || !mainPathFile.isDirectory())
            throw new FileNotFoundException("File " + path + " not found!");

        var file = new File(mainPathFile, path);
        if (!file.exists())
            throw new FileNotFoundException("File " + path + " not found!");

        try {
            if (!helper.FileIsInMainDir(file))
                throw new FileNotFoundException("File " + path + " not found!");
        } catch (IOException ex) {
            log.error(ex);
            throw new RuntimeException("Internal Error");
        }

        return file;
    }
  
}
