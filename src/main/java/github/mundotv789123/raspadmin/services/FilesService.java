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
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
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

        for (File fileList : file.listFiles()) {
            String filePath = helper.getOriginalPath(fileList);
            Optional<FileModel> fileOptional = filesFromDatabase.stream().filter(
                f -> f.getFilePath().equals(filePath)).findAny();
            FileModel fileModel = validateFileModel(fileList, fileOptional);
            filesFromDatabase.remove(fileModel);
            filesReturn.add(fileModel);
        }

        return filesReturn;
    }

    public FileModel validateFileModel(File file, Optional<FileModel> fileOptional) throws IOException {
        FileModel fileModel;
        if (!fileOptional.isPresent()) {
            fileModel = helper.convertFileToFileModel(file);
            log.info("File not found on database: " + fileModel.getFilePath());
            if (fileModel.isDir()) {
                File fileIcon = helper.getIconOfDir(file);
                if (fileIcon != null) {
                    fileModel.setIconPath(helper.getOriginalPath(fileIcon));
                    log.info("Save icon dir: " + fileModel.getFilePath());
                }
            }
            fileRepository.save(fileModel);
            return fileModel;
        }
        
        fileModel = fileOptional.get();
        if (!helper.isSimilar(fileModel, file)) {
            helper.updateFileModel(fileModel, file);
            fileRepository.save(fileModel);
            log.info("File updated: " + fileModel.getFilePath());
        }

        if (fileModel.getIconPath() != null
                && !new File(appConfig.getMainPathFile(), fileModel.getIconPath()).exists()) {
            fileModel.setGenerateIcon();
            fileRepository.save(fileModel);
            log.info("Reset icon generator: " + fileModel.getFilePath());
        }

        if (fileModel.isDir() && fileModel.getIconPath() == null) {
            File fileIcon = helper.getIconOfDir(file);
            if (fileIcon != null) {
                fileModel.setIconPath(helper.getOriginalPath(fileIcon));
                fileRepository.save(fileModel);
                log.info("Save icon dir: " + fileModel.getFilePath());
            }
        }

        return fileModel;
    }

    public void deleteAllFromDatabase(List<FileModel> files) {
        for (FileModel file : files) {
            log.info(file.getFilePath() + " deleted from database");
            fileRepository.delete(file);
        }
        files.clear();
    }
}
