package com.example.auctions_web.repository;

import com.example.auctions_web.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
