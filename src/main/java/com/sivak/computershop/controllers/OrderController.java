package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.LaptopsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    private LaptopsRepo laptopsRepo;

    @GetMapping("/order")
    private String order() {



        return "order";
    }


    @PostMapping("/order")
    public String buyOrder(
            @AuthenticationPrincipal Users users,
            @RequestParam Long buyProduct,
            @RequestParam Class typeOdClass,
            Model model
    ) {



//        if (buyProduct instanceof Laptops) {
//            Optional<Laptops> laptops = laptopsRepo.findById(((Laptops)buyProduct).getId());
//            model.addAttribute("laptops", laptops);
//        }


//
////        Laptops laptops = (Laptops) buyProduct;
//////        Laptops laptops2 = product;

        return "redirect:/order";
    }
}
