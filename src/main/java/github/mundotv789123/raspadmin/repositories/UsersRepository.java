package github.mundotv789123.raspadmin.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import github.mundotv789123.raspadmin.models.UserModel;

public interface UsersRepository extends CrudRepository<UserModel, Integer> {
    public Optional<UserModel> findByUsername(String path);
}
