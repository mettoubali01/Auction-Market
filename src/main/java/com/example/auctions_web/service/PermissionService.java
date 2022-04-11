package com.example.auctions_web.service;

import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import com.example.auctions_web.repository.IPermissionRepository;
import com.example.auctions_web.repository.IRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PermissionService implements IPermissionService {

    private final IPermissionRepository permissionRepository;
    private final IRoleRepository roleRepository;

    public PermissionService(IPermissionRepository permissionRepository, IRoleRepository roleRepository) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Permission getPermissionByName(String name) {
        return permissionRepository
                .findById(name)
                .orElseThrow(() -> new RuntimeException("Permission not found with name " + name));
    }

    @Override
    public Role addPermission(String roleName, String permissionName) {
        Role role = roleRepository
                .findRoleByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found with name " + roleName));

        Optional<Permission> permission = permissionRepository.findById(permissionName);

        if (permission.isPresent()) {
            role.addPermission(permission.get());
        } else {
            Permission permission1 = new Permission();
            permission1.setPermissionName(permissionName);
            role.addPermission(permission1);
        }

        roleRepository.save(role);

        return role;
    }

    @Override
    public Permission updatePermission(String newName, String oldName) {
        Permission permission = permissionRepository
                .findById(oldName)
                .orElseThrow(() -> new RuntimeException(" We couldn't find Role name with " + oldName));
        permission.setPermissionName(newName);

        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> retrievePermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Set<Permission> retrievePermissionsByRoleName(String name) {
        Role role = roleRepository
                .findRoleByRoleName(name)
                .orElseThrow(() -> new RuntimeException("Role not found with " + name));

        return role.getPermissions();
    }

    @Override
    public boolean removePermissionByName(String name) {
        permissionRepository.deleteById(name);
        return true;
    }

    @Override
    public boolean removePermissionByNameFromRole(String permissionName, String roleName) {
        Role role = roleRepository
                .findRoleByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found with name " + roleName));

        if (role != null) {
            role.removePermission(permissionName);
            roleRepository.save(role);
            return true;
        }

        return false;
    }
}
