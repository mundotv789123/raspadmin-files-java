package github.mundotv789123.raspadmin.services;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileModel;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
@Component
public class FilesManagerService {

    private final AppConfig appConfig;
    private final FileIconService fileIconService;

    public FilesManagerService(AppConfig appConfig, FileIconService fileIconService) {
        this.appConfig = appConfig;
        this.fileIconService = fileIconService;
    }

    public Collection<FileModel> getFiles(String path) throws FileNotFoundException, IOException {
        String pathFile = (path == null || path.matches("\\/*")) ? "" : path;
        var file = getFileByPath(pathFile);
        
        if (!file.isDirectory())
            return List.of(getModel(file, true));

        List<FileModel> files = new ArrayList<>();
        for (File subFile : file.listFiles()) {
            files.add(getModel(subFile, false));
        }

        return files;
    }

    public File getFileByPath(String path) throws FileNotFoundException {
        File mainPathFile = appConfig.getMainPathFile();
        if (!mainPathFile.exists() || !mainPathFile.isDirectory())
            throw new FileNotFoundException("File " + path + " not found!");

        var file = new File(mainPathFile, path);
        if (!file.exists())
            throw new FileNotFoundException("File " + path + " not found!");

        try {
            if (!file.getCanonicalPath().startsWith(mainPathFile.getCanonicalPath()))
                throw new IOException();
        } catch (IOException ex) {
            throw new FileNotFoundException("File not found!");
        }

        return file;
    }

    private FileModel getModel(File file, boolean open) throws IOException{
        var fileModel = FileModel.fileToModel(file, open);
        File fileIcon = fileIconService.getFileIcon(file);
        try {
            if (fileIcon != null) {
                String videoPath = fileIcon.getCanonicalPath().substring(appConfig.getMainPathFile().getCanonicalPath().length());
                fileModel.setIcon(videoPath);
            }
            
            if (file.isFile()) {
                String type = Files.probeContentType(file.toPath());
                fileModel.setType(type);
            }
        } catch (IOException ex) {
            log.error(ex);
        }
        return fileModel;
    }
    
}
