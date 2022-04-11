package com.example.auctions_web;

import com.example.auctions_web.service.PermissionService;
import com.example.auctions_web.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuctionsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionsWebApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleService roleService, PermissionService permissionService) {
        return args -> {
            roleService.addNewRole("ADMIN");
            roleService.addNewRole("CUSTOMER");

            permissionService.addPermission("ADMIN", "CREATE");
            permissionService.addPermission("ADMIN", "UPDATE");
            permissionService.addPermission("ADMIN", "DELETE");
            permissionService.addPermission("ADMIN", "READ");

            permissionService.addPermission("CUSTOMER", "READ");
        };
    }
}
