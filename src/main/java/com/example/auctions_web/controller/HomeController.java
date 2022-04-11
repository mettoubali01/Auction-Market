package com.example.auctions_web.controller;

import com.example.auctions_web.model.Role;
import com.example.auctions_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final RoleService roleService;

    public HomeController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public String index(Model model){
        //Sending the title page
        model.addAttribute("title", "Home");
        List<Role> list = roleService.retrieveRoles();

        for (Role role : list) {
            System.out.println(role);
        }
        return "index";
    }
}
