package github.mundotv789123.raspadmin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.entities.PermissionEntity;
import github.mundotv789123.raspadmin.models.entities.RoleEntity;
import github.mundotv789123.raspadmin.models.entities.UserEntity;

@Service
public class UsersRespository {
    /*
     * Nesse serviço estou usando usuários configurados no application.properties.
     * Caso prefira configurar um banco de dados basta alterar essa class.
     */

    @Value("${application.security.user.name}")
    private String username;

    @Value("${application.security.user.password}")
    private String password;

    public Optional<UserEntity> findUserByUsername(String username) {
        var passwordEncoder = new BCryptPasswordEncoder();
        if (this.username != null && this.username.equals(username)) {
            var permission = new PermissionEntity("create_user");
            var role = new RoleEntity();
            role.addPermission(permission);

            return Optional.of(new UserEntity(username, passwordEncoder.encode(password), List.of(role)));
        }
        return Optional.empty();
    }
}
