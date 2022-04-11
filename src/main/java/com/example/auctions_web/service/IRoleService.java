package com.example.auctions_web.service;

import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRoleService {
    boolean removeRoleByName(String name);
    Optional<Role> getRoleByName(String name);
    Optional<Role> addNewRole(String name);
    Role updateRole(String newN, String oldName);
    List<Role> retrieveRoles();
    Set<Permission> retrievePermissionByRole(String role);
}
