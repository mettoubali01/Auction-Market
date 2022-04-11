package com.example.auctions_web.repository;

import com.example.auctions_web.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
}
