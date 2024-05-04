package github.mundotv789123.raspadmin.models.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import github.mundotv789123.raspadmin.models.FileModel;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FileDTO {
 @GeneratedValue
    private @Getter String name;
    private @Getter long size;
    private @JsonProperty("is_dir") @Getter boolean dir;
    private @Getter String type;
    private @Getter String icon;
    private @Getter String path;
    private @JsonProperty("updated_at") @Getter Calendar updatedAt;
    private @Getter boolean open;

    public static FileDTO toDTO(FileModel model, boolean open) {
        return new FileDTO(
            model.getName(), 
            model.getSize(), 
            model.isDir(), 
            model.getType(), 
            model.getIconPath(), 
            model.getFilePath(), 
            model.getUpdatedAt(),
            open
        );
    }
}
