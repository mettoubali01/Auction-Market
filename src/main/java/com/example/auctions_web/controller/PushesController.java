package com.example.auctions_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PushesController {

    @GetMapping(value = "/pushes")
    public String pushes(){
        return "pushes";
    }
}
