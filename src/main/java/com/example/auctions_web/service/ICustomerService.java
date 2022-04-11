package com.example.auctions_web.service;

import com.example.auctions_web.model.Customer;
import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import java.util.List;
import java.util.Set;

public interface ICustomerService {
    boolean removeCustomerByEmail(String email);
    Customer addNewCustomer(Customer customer);
    Role retrieveCustomerRolesByEmail(String email);
    Customer addRoleToCustomer(String roleName, Customer customer);
    List<Permission> retrieveCustomerPermissionByEmail(String email);
    Set<Permission> retrievePermissionsByRoleName(String name);
}