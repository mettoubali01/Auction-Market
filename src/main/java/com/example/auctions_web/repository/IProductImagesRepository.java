package com.example.auctions_web.repository;

import com.example.auctions_web.beans.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImagesRepository extends JpaRepository<ProductImages, Long> {
}
