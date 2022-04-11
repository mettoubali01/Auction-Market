package com.example.auctions_web.service;

import com.example.auctions_web.model.Customer;
import com.example.auctions_web.model.Permission;
import com.example.auctions_web.model.Role;
import com.example.auctions_web.repository.ICustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
//
@Service
public class CustomerService implements ICustomerService{

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean removeCustomerByEmail(String email) {
        customerRepository.deleteById(email);
        return true;
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Role retrieveCustomerRolesByEmail(String email) {

        return null;
    }

    @Override
    public Customer addRoleToCustomer(String roleName, Customer customer) {
        return null;
    }

    @Override
    public List<Permission> retrieveCustomerPermissionByEmail(String email) {
        return null;
    }

    @Override
    public Set<Permission> retrievePermissionsByRoleName(String name) {
        return null;
    }
}
