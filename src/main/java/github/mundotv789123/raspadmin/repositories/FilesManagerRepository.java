package github.mundotv789123.raspadmin.repositories;

import github.mundotv789123.raspadmin.models.FileModel;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilesManagerRepository {

    public static final String MAIN_PATH = "./files";

    public List<FileModel> getFiles(String path) throws FileNotFoundException {
        var file = getFileByPath(path != null ? path : ".");

        var files = new ArrayList<FileModel>();
        if (!file.isDirectory()) {
            files.add(FileModel.fileToModel(file, true));
            return files;
        }

        for (String fileName : file.list()) {
            var subFile = new File(file, fileName);
            var fileModel = FileModel.fileToModel(subFile);
            File fileIcon = getFileIcon(subFile);
            if (fileIcon != null)
                fileModel.setIcon(path + "/" + fileName + "/" + fileIcon.getName());
            files.add(fileModel);
        }

        return files;
    }

    public File getFileByPath(String path) throws FileNotFoundException {
        var filePath = new File(MAIN_PATH);
        if (!filePath.exists() || !filePath.isDirectory())
            throw new FileNotFoundException("File " + path + "not found!");

        var file = new File(MAIN_PATH, path);
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
        if (file.isDirectory()) {
            File iconPng = new File(file, "_icon.png");
            if (iconPng.exists()) {
                return iconPng;
            }
            File iconJpg = new File(file, "_icon.jpg");
            if (iconJpg.exists()) {
                return iconJpg;
            }
            File iconJpeg = new File(file, "_icon.jpeg");
            if (iconJpeg.exists()) {
                return iconJpeg;
            }
        }
        return null;
    }
}
