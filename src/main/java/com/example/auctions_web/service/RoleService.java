package com.example.auctions_web.service;

import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import com.example.auctions_web.repository.IRoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean removeRoleByName(String name) {
        return false;
    }

    @Override
    public Optional<Role> getRoleByName(String name) {

        return roleRepository.findRoleByRoleName(name);

    }

    @Override
    public Optional<Role> addNewRole(String name) {

        Role role = new Role();
        role.setRoleName(name);
        roleRepository.save(role);

        return Optional.of(role);
    }

    @Override
    public Role updateRole(String newName, String oldName) {

        Role role = roleRepository
                .findRoleByRoleName(oldName)
                .orElseThrow(() -> new RuntimeException(" We couldn't find Role name with " + oldName));
        role.setRoleName(newName);
        role.setPermissions(role.getPermissions());

        return roleRepository.save(role);
    }

    @Override
    public List<Role> retrieveRoles() {

        return roleRepository.findAll();
    }

    @Override
    public Set<Permission> retrievePermissionByRole(String roleName) {

        Optional<Role> role = roleRepository.findRoleByRoleName(roleName);
        return role.map(Role::getPermissions).orElse(null);

    }
}
