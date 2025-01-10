package github.mundotv789123.raspadmin.models.entities;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PermissionEntity implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }

}
