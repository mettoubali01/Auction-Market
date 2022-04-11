package com.example.auctions_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
public class Permission {

    @Id
    @JsonIgnore
    private String permissionName;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "permissions"
    )
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String name) {
        this.permissionName = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionName='" + permissionName + '\'' +
                '}';
    }
}

