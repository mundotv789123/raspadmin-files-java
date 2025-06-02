package github.mundotv789123.raspadmin.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.entities.UserEntity;

@Service
public interface UsersRespository extends CrudRepository<UserEntity, Long>{
    public Optional<UserEntity> findUserByUsername(String username);
}
