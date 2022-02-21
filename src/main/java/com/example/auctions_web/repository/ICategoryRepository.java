package com.example.auctions_web.repository;

import com.example.auctions_web.beans.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<ProductCategory, String> {

}
