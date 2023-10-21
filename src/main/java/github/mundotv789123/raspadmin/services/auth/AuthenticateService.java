package github.mundotv789123.raspadmin.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.repositories.UsersRespository;



@Service
public class AuthenticateService implements UserDetailsService {

    @Autowired
    private UsersRespository respository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = respository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username");
        return user;
    }
}
