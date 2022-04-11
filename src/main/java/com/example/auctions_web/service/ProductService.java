package com.example.auctions_web.service;

import com.example.auctions_web.model.Product;
import com.example.auctions_web.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product addProduct(Product product) {
        iProductRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public Product getProductByCategory(String category) {
        return null;
    }

    @Override
    public void rmByID(Long id) {

    }

    @Override
    public void rmByName(String name) {

    }
}
