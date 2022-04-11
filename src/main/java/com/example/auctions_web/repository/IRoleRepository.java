package com.example.auctions_web.repository;

import com.example.auctions_web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findRoleByRoleName(String roleName);
}
