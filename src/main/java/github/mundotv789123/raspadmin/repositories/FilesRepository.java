package github.mundotv789123.raspadmin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import github.mundotv789123.raspadmin.models.entities.FileEntity;

public interface FilesRepository extends CrudRepository<FileEntity, Long> {
    public Optional<FileEntity> findByFilePath(String path);
    public Optional<FileEntity> findByIconPath(String path);
    public List<FileEntity> findAllByParentPath(String path);
}
