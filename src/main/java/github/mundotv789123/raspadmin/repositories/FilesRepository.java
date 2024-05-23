package github.mundotv789123.raspadmin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import github.mundotv789123.raspadmin.models.FileModel;

public interface FilesRepository extends CrudRepository<FileModel, Long> {
    public Optional<FileModel> findByFilePath(String path);
    public Optional<FileModel> findByIconPath(String path);
    public List<FileModel> findAllByParentPath(String path);
}
