package com.example.auctions_web.controller;

import com.example.auctions_web.beans.Product;
import com.example.auctions_web.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @PostMapping(value = "/add")
    public Product addNewProduct(@RequestBody Product product){
        return iProductService.addProduct(product);
    }
}
