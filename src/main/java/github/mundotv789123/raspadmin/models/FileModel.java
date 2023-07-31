package github.mundotv789123.raspadmin.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class FileModel {

    private final @Getter String name;
    private final @Getter @JsonProperty("is_dir") boolean dir;
    private final @Getter String icon;
    private final @Getter String type;
    private final @Getter boolean open;

    public static FileModel fileToModel(File file) {
        return fileToModel(file, false);
    }

    public static FileModel fileToModel(@NonNull File file, boolean open) {
        return new FileModel(file.getName(), file.isDirectory(), null, null, open);
    }
}
