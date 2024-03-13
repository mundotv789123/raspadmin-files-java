package github.mundotv789123.raspadmin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name="file_icons")
public class FileIconModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Id Integer Id;
    @Column(name = "path_file", unique=true)
    private @Getter String pathFile;
    @Column(name = "path_icon")
    private @Getter String pathIcon;

    @Column(name = "file_last_modified")
    private @Getter Long lastModified;

    @Column(name = "file_size")
    private @Getter Long size;

    private FileIconModel() { }

    public FileIconModel(String pathFile, String pathIcon, Long size, Long lastModified) {
        this.pathFile = pathFile;
        this.pathIcon = pathIcon;
        this.size = size;
        this.lastModified = lastModified;
    }

    public FileIconModel(String pathFile, String pathIcon) {
        this.pathFile = pathFile;
        this.pathIcon = pathIcon;
    }
}
