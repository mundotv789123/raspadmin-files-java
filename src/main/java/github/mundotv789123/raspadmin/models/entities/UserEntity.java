package github.mundotv789123.raspadmin.models.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {

    private @Getter String username;
    private @Getter String password;
    private @Getter List<RoleEntity> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getPermissions().stream()).toList();
    }
}
