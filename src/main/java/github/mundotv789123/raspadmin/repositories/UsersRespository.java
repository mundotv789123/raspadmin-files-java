package github.mundotv789123.raspadmin.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.UserModel;

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

    public UserModel findUserByUsername(String username) {
        var passwordEncoder = new BCryptPasswordEncoder();
        if (this.username != null && this.username.equals(username)) {
            return new UserModel(username, passwordEncoder.encode(password));
        }
        return null;
    }
}
