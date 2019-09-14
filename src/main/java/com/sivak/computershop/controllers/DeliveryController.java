package com.sivak.computershop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryController {
    
    @GetMapping("/delivery")
    public String delivery(Model model) {
    
        model.addAttribute("activeDelivery", "active");
        
        return "delivery";
    }
}
