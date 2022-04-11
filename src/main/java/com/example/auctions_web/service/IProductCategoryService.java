package com.example.auctions_web.service;


import com.example.auctions_web.model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    ProductCategory addCategory(ProductCategory productCategory);
    List<ProductCategory> getCategories();
    ProductCategory getCategoryByName(String name);
    void rmByName(String name);
}
