package github.mundotv789123.raspadmin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Calendar;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Entity(name="files")
public class FileModel {
    
    @GeneratedValue
    private @Id long id;
    private @Getter String name;
    private @Getter @Setter long size;

    @Column(name = "is_dir")
    private @Getter @Setter boolean dir;
    private @Getter @Setter String type;

    @Column(name = "generate_icon")
    private @Getter boolean generateIcon;

    @Column(name = "icon_path")
    private @Getter String iconPath;

    @Column(name = "file_path")
    private @Getter String filePath;

    @Column(name = "parent_path")
    private @Getter String parentPath;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter Calendar updatedAt;

    public FileModel(String name, String filePath, String parentPath) {
        this.name = name;
        this.filePath = filePath;
        this.parentPath = parentPath;
    }

    private FileModel() { }

    public void setGenerateIcon() {
        this.generateIcon = true;
        this.iconPath = null;
    }

    public void setIconPath(@Nullable String iconPath) {
        this.iconPath = iconPath;
        this.generateIcon = false;
    }
}
