package github.mundotv789123.raspadmin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import github.mundotv789123.raspadmin.models.FileIconModel;

public interface FileIconsRepository extends CrudRepository<FileIconModel, Integer> {
    public Optional<FileIconModel> findByPathFile(String path);
    public Optional<FileIconModel> findByPathIcon(String path);
    public List<FileIconModel> findByPathFileIn(List<String> paths);
}
