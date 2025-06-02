package github.mundotv789123.raspadmin.models.enums;

import lombok.Getter;

public enum PermissionEnum {
    CREATE_USERS("CREATE_USERS");
    private @Getter String name;
    private PermissionEnum(String name) {
        this.name = name;
    }
}
