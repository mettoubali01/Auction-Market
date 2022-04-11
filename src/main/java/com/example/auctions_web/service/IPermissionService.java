package com.example.auctions_web.service;

import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import java.util.List;
import java.util.Set;

public interface IPermissionService {
    boolean removePermissionByName(String name);
    boolean removePermissionByNameFromRole(String permissionName, String roleName);
    Permission getPermissionByName(String name);
    Role addPermission(String roleName, String Name);
    List<Permission> retrievePermission();
    Set<Permission> retrievePermissionsByRoleName(String name);
    Permission updatePermission(String newName, String oldName);
}