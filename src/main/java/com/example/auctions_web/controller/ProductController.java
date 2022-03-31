package com.example.auctions_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/upload")
    public String uploadProduct(){
        return "upload_product";
    }

    @GetMapping(value = "/item")
    public String productInfo(){
        return "product_info";
    }

    @GetMapping(value = "/products")
    public String products(){
        return "product_list";
    }

    @GetMapping(value = "/pushes")
    public String pushes(){
        return "pushes";
    }
}
