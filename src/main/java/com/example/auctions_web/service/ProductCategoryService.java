    package com.example.auctions_web.service;

import com.example.auctions_web.model.ProductCategory;
import com.example.auctions_web.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService{

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public ProductCategory addCategory(ProductCategory productCategory) {
        return iCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> getCategories() {
        return iCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getCategoryByName(String name) {
        return null;
    }

    @Override
    public void rmByName(String name) {

    }
}