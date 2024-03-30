package github.mundotv789123.raspadmin.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import github.mundotv789123.raspadmin.models.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
public class UserModel implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Id int id;

    @Column(unique = true)
    private @Getter String username;

    private @Getter String password;

    @Enumerated(EnumType.STRING)
    private @Getter UserRole role;

    private @Getter @Setter boolean enabled;

    private UserModel() { }

    public UserModel(String username, String password, UserRole role, boolean enabled) {
        this.username = username;
        this.role = role;
        var passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
  
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.toString()));
    }
}
