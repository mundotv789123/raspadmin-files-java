package github.mundotv789123.raspadmin.models.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class RoleEntity {
    private @Getter List<PermissionEntity> permissions = new ArrayList<>();

    public void addPermission(PermissionEntity permission) {
        this.permissions.add(permission);
    }
}
