package github.mundotv789123.raspadmin.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.repositories.FilesRepository;

@Service
public class FilesService {

    private final AppConfig appConfig;
    private final FilesHelper helper;
    private final FilesRepository fileRepository;

    public FilesService(FilesRepository fileRepository, AppConfig appConfig, FilesHelper helper) {
        this.fileRepository = fileRepository;
        this.helper = helper;
        this.appConfig = appConfig;
    }
    
    public List<FileModel> getAllFilesFromDir(File file) throws IOException {
        String path = helper.getOriginalPath(file);

        List<FileModel> filesReturn = new ArrayList<>();
        if (!file.isDirectory()) {
            Optional<FileModel> fileModel = fileRepository.findByFilePath(path);
            filesReturn.add(validateFileModel(file, fileModel));
            return filesReturn;
        }

        List<FileModel> filesFromDatabase = fileRepository.findAllByParentPath(path);
        
        for (File fileList: file.listFiles()) {
            String filePath = helper.getOriginalPath(fileList);
            Optional<FileModel> fileOptional = filesFromDatabase.stream().filter(
                f -> f.getFilePath().equals(filePath)
            ).findAny();
            FileModel fileModel = validateFileModel(fileList, fileOptional);
            filesFromDatabase.remove(fileModel);
            filesReturn.add(fileModel);
        }
        
        return filesReturn;
    }

    public FileModel validateFileModel(File file, Optional<FileModel> fileOptional) throws IOException {
        FileModel fileModel;
        if(fileOptional.isPresent()) {
            fileModel = fileOptional.get();
            if (!helper.isSimilar(fileModel, file)) {
                helper.updateFileModel(fileModel, file);
                fileRepository.save(fileModel);
            }
            if (fileModel.getIconPath() != null && !new File(appConfig.getMainPathFile(), fileModel.getIconPath()).exists()) {
                fileModel.setGenerateIcon();
                fileRepository.save(fileModel);
            }
        } else {
            fileModel = helper.convertFileToFileModel(file);
            fileRepository.save(fileModel);
        }
        return fileModel;
    }

    public void deleteAllFromDatabase(List<FileModel> files) {
        for (FileModel file : files) {
            fileRepository.delete(file);
        }
        files.clear();
    }
}
