package github.mundotv789123.raspadmin.repositories;

import github.mundotv789123.raspadmin.models.FileModel;
import jakarta.annotation.Nullable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class FilesManagerRepository {

    @Value("${application.filesmanager.path:./files}")
    private String mainPath;

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
            if (fileIcon != null)
                fileModel.setIcon(pathFile + "/" + (subFile.isDirectory() ? fileName + "/" : "") + fileIcon.getName());
            files.add(fileModel);
        }

        return files;
    }

    public File getFileByPath(String path) throws FileNotFoundException {
        var filePath = new File(mainPath);
        if (!filePath.exists() || !filePath.isDirectory())
            throw new FileNotFoundException("File " + path + "not found!");

        var file = new File(mainPath, path);
        if (!file.exists())
            throw new FileNotFoundException("File " + path + "not found!");

        try {
            if (!file.getCanonicalPath().startsWith(filePath.getCanonicalPath()))
                throw new IOException();
        } catch (IOException ex) {
            throw new FileNotFoundException("File not found!");
        }

        return file;
    }

    public @Nullable File getFileIcon(File file) {
        if (!file.isDirectory()) {
            for (String fileName : file.getParentFile().list()) {
                if (!fileName.matches("^_"+ file.getName() +"\\.(png|jpe?g|svg|webp)$")) 
                    continue;
    
                File fileIcon = new File(file.getParentFile(), fileName);
                if (fileIcon.isFile())
                    return fileIcon;
            }
            return null;
        }

        for (String fileName : file.list()) {
            if (!fileName.matches("^_icon\\.(png|jpe?g|svg|webp)$")) 
                continue;

            File fileIcon = new File(file, fileName);
            if (fileIcon.isFile())
                return fileIcon;
        }
        return null;
    }
}
