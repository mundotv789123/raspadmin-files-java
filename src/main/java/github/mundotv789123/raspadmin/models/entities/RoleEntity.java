package github.mundotv789123.raspadmin.models.entities;

import java.util.ArrayList;
import java.util.List;

import github.mundotv789123.raspadmin.models.enums.PermissionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name = "roles")
public class RoleEntity {
    @GeneratedValue
    private @Getter @Id long id;
    private @Getter String name;
    private @Getter List<PermissionEnum> permissions = new ArrayList<>();

    public void addPermission(PermissionEnum permission) {
        this.permissions.add(permission);
    }
}
