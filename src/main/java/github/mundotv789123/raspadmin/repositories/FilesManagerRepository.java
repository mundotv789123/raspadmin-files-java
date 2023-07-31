package github.mundotv789123.raspadmin.repositories;

import github.mundotv789123.raspadmin.models.FileModel;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilesManagerRepository {

    public final String mainPath = "./files";

    public List<FileModel> getFiles(String path) throws FileNotFoundException {
        var file = getFileByPath(path);

        var files = new ArrayList<FileModel>();
        if (!file.isDirectory()) {
            files.add(FileModel.fileToModel(file, true));
            return files;
        }

        for (String fileName : file.list()) {
            var subFile = new File(file, fileName);
            files.add(FileModel.fileToModel(subFile));
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
}
