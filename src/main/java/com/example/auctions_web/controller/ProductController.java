package com.example.auctions_web.controller;

import com.example.auctions_web.beans.Product;
import com.example.auctions_web.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/")
    public String addNewProduct(){
        return "index";
    }
}
