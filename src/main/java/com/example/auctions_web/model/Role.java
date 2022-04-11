package com.example.auctions_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Role {

    @Id
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    @JsonIgnore
    private List<Customer> customers;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }

    )
    private Set<Permission> permissions = new HashSet<>();

    public Role() {}

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
        System.out.println("permission Size " + this.permissions.size());
        System.out.println("Permissions role size " + permission);

        permission.getRoles().add(this);
    }

    public void removePermission(String permissionName) {
        Permission permission = this.permissions.stream().filter(
                perm ->
                        perm.getPermissionName().equals(permissionName)).findFirst().orElse(null
        );

        if (permission != null) {
            this.permissions.remove(permission);
            permission.getRoles().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", \npermissions=" + permissions +
                '}';
    }
}