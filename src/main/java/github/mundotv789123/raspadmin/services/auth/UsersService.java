package github.mundotv789123.raspadmin.services.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.entities.RoleEntity;
import github.mundotv789123.raspadmin.models.entities.UserEntity;
import github.mundotv789123.raspadmin.models.enums.PermissionEnum;
import github.mundotv789123.raspadmin.repositories.UsersRespository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    @Value("${application.security.user.name}")
    private String username;

    @Value("${application.security.user.password}")
    private String password;

    private final UsersRespository respository;

    public Optional<UserEntity> findUserByUsername(String username) {
        var user = findEnvUser(username);
        if (user.isPresent()) {
            return user;
        }

        user = respository.findUserByUsername(username);
        return user;
    }

    private Optional<UserEntity> findEnvUser(String username) {
        var passwordEncoder = new BCryptPasswordEncoder();
        if (this.username != null && this.username.equals(username)) {
            var role = new RoleEntity();
            for(var permission:PermissionEnum.values()) {
                role.addPermission(permission);
            }

            return Optional.of(new UserEntity(0, username, passwordEncoder.encode(password), List.of(role)));
        }
        return Optional.empty();
    }
}
