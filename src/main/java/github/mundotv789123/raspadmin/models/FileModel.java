package github.mundotv789123.raspadmin.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class FileModel {

    private final @Getter String name;
    private final @Getter @JsonProperty("is_dir") boolean dir;
    private @Getter @Setter String icon;
    private final @Getter String type;
    private final @Getter boolean open;

    private @Getter @JsonProperty("created_at") Date createdAt;

    public static FileModel fileToModel(@NonNull File file) throws IOException {
        return fileToModel(file, false);
    }

    public static FileModel fileToModel(@NonNull File file, boolean open) throws IOException {
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        Date createdAt = new Date(basicFileAttributes.creationTime().toMillis());

        return new FileModel(file.getName(), file.isDirectory(), null, null, open, createdAt);
    }
}
