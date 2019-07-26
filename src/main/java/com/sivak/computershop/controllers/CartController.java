package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.entities.Orders;
import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.OrdersRepo;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping("/cart")
    public String cart() {


        return "cart";
    }

    @PostMapping("/buy")
    public String buy(
            @AuthenticationPrincipal Users user,
            @RequestParam(value = "laptopId", required = false) List<Laptops> laptops,
            @RequestParam(value = "tabletId", required = false) List<Tablets> tablets,
            @RequestParam boolean isAddAll
    ) {

        if (isAddAll) {
            laptops = user.getLaptops();
            tablets = user.getTablets();
        }

        Orders order = new Orders(user);

        if (laptops != null) {
            order.getLaptops().addAll(laptops);
        }

        if (tablets != null) {
            order.getTablets().addAll(tablets);
        }

        if (laptops != null || tablets != null) {
            removeFromCart(user, laptops, tablets);
        }

        ordersRepo.save(order);
        System.out.println(order);

        return "redirect:/cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(
            @AuthenticationPrincipal Users user,
            @RequestParam(value = "removeLaptop", required = false) List<Laptops> laptops,
            @RequestParam(value = "removeTablet", required = false)  List<Tablets> tablets
    ) {

        if (laptops != null) {
            List<Laptops> laptopsList = user.getLaptops();
            laptopsList.removeAll(laptops);
        }

        if (tablets != null) {
            List<Tablets> tabletsList = user.getTablets();
            tabletsList.removeAll(tablets);
        }

        userRepo.save(user);

        return "redirect:/cart";
    }


}
