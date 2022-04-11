package com.example.auctions_web.service;

import com.example.auctions_web.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    List<Product> getProducts();
    Product getProductByName(String name);
    Product getProductByCategory(String category);
    void rmByID(Long id);
    void rmByName(String name);
}
