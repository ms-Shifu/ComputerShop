package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/cart")
    public String cart() {

        return "cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(
            @AuthenticationPrincipal Users user,
            @RequestParam(value = "removeLaptop", required = false) Laptops laptop,
            @RequestParam(value = "removeTablet", required = false) Tablets tablet
    ) {

        if (laptop != null) {
            List<Laptops> laptopsList = user.getLaptops();
            laptopsList.remove(laptop);
        }

        if (tablet != null) {
            List<Tablets> tabletsList = user.getTablets();
            tabletsList.remove(tablet);
        }

        userRepo.save(user);

        return "redirect:/cart";
    }
}