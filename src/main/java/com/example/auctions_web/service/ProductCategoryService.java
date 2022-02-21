    package com.example.auctions_web.service;

import com.example.auctions_web.beans.ProductCategory;
import com.example.auctions_web.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService{

    @Autowired
    private IProductCategoryRepository iProductCategoryRepository;

    @Override
    public ProductCategory addCategory(ProductCategory productCategory) {
        return iProductCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> getCategories() {
        return iProductCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getCategoryByName(String name) {
//        return iProductCategoryRepository.findById(Long.valueOf(name));
        return null;
    }

    @Override
    public void rmByName(String name) {

    }
}