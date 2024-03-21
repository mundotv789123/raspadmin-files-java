package github.mundotv789123.raspadmin.services.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.services.UsersManager;

@Service
public class AuthenticateService implements UserDetailsService {

    private final UsersManager manager;

    public AuthenticateService(UsersManager manager) {
        this.manager = manager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = manager.findUserByUsername(username);
        if (!user.isPresent())
            throw new UsernameNotFoundException("Invalid username");
        return user.get();
    }
}
