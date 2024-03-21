package github.mundotv789123.raspadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.models.enums.UserRole;
import github.mundotv789123.raspadmin.repositories.UsersRepository;

@Service
public class UsersManager {
    @Value("${application.security.user.name}")
    private String username;

    @Value("${application.security.user.password}")
    private String password;

    private UsersRepository repository;

    public UsersManager(UsersRepository repository) {
        this.repository = repository;
    }

    public Optional<UserModel> findUserByUsername(String username) {
        if (this.username != null && this.username.equals(username)) {
            return Optional.of(new UserModel(username, this.password, UserRole.ADMIN, true));
        }
        return repository.findByUsername(username);
    }
}
