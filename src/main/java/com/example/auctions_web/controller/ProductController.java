package com.example.auctions_web.controller;

import com.example.auctions_web.dto.ProductUploadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    @GetMapping(value = "/add/product")
    public String uploadProduct(Model model,
                                ProductUploadDto productUploadDto){
        model.addAttribute("msg", "error");

        return "upload_product";
    }

    @PostMapping(value = "/upload")
    public String uploadProductSubmit(@Valid ProductUploadDto productUploadDto,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes,
                                      Model model){

        if (bindingResult.hasErrors())
            return "upload_product";

        System.out.println(productUploadDto.getTitle());
        redirectAttributes.addFlashAttribute("msg", "success");

        return "redirect:/";
    }

    @GetMapping(value = "/item")
    public String productInfo(){
        return "product_info";
    }

    @GetMapping(value = "/products")
    public String products(){
        return "product_list";
    }

}
