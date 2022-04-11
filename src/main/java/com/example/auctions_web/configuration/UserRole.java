package com.example.auctions_web.configuration;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.auctions_web.configuration.UserPermission.CUSTOMER_READ;
import static com.example.auctions_web.configuration.UserPermission.ADMIN_READ;
import static com.example.auctions_web.configuration.UserPermission.ADMIN_WRITE;

public enum UserRole {
    CUSTOMER(new HashSet(Arrays.asList(CUSTOMER_READ))),
    ADMIN(new HashSet(Arrays.asList(ADMIN_READ, ADMIN_WRITE)));

    private Set<UserPermission> userPermissionSet;

    UserRole(Set<UserPermission> userPermissionSet) {
        this.userPermissionSet = userPermissionSet;
    }

    public Set<UserPermission> getUserPermissionSet() {
        return userPermissionSet;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getUserPermissionSet().stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        for (SimpleGrantedAuthority s : permissions) {
            System.out.println("permission " + permissions);
        }
        return permissions;
    }

}