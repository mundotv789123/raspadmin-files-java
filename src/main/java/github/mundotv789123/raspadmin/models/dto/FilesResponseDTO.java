package github.mundotv789123.raspadmin.models.dto;

import java.util.List;

import github.mundotv789123.raspadmin.models.FileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FilesResponseDTO {
    private final @Getter List<FileModel> files;
}
