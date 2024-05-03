package github.mundotv789123.raspadmin.models;

import java.io.File;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="fileicons")
public class FileIconModel {
    @GeneratedValue
    private @Getter @Id Integer Id;
    @Column(name = "path_file", unique=true)
    private @Getter String pathFile;
    @Column(name = "path_icon")
    private @Getter String pathIcon;
    @Column(name = "path_parent")
    private @Setter @Getter String pathParent;

    @Column(name = "file_last_modified")
    private @Getter Long lastModified;
    @Column(name = "file_size")
    private @Getter Long size;

    private FileIconModel() { }

    public FileIconModel(String pathFile, String pathIcon, String pathParent, Long size, Long lastModified) {
        this.pathFile = pathFile;
        this.pathIcon = pathIcon;
        this.size = size;
        this.lastModified = lastModified;
        this.pathParent = pathFile;
    }

    public FileIconModel(String pathFile, String pathIcon, String pathParent) {
        this.pathFile = pathFile;
        this.pathIcon = pathIcon;
        this.pathParent = pathFile;
    }

    public boolean isSimilar(File file) {
        if (this.getLastModified() == null || this.getSize() == null)
            return true;
        return (this.getSize().equals(file.length())) && this.getLastModified().equals(file.lastModified());
    }
}
