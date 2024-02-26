package github.mundotv789123.raspadmin.services.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.repositories.UsersRespository;

@Service
public class AuthenticateService implements UserDetailsService {

    private final UsersRespository respository;

    public AuthenticateService(UsersRespository respository) {
        this.respository = respository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = respository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username");
        return user;
    }
}
