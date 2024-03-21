package github.mundotv789123.raspadmin.models.dto;
import java.util.List;
import github.mundotv789123.raspadmin.models.FileModel;
import lombok.Getter;

public record FilesResponseDTO(@Getter List<FileModel> files) {} 
