package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Orders;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

   @Autowired
   private OrdersRepo ordersRepo;



    @GetMapping("/orders")
    public String orders(Model model) {

        List<Orders> orders = ordersRepo.findAll();

        model.addAttribute("orders", orders);

        System.out.println(orders);

        return "orders";
    }


    @PostMapping("/orders")
    public String buyOrders(
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

        return "redirect:/orders";
    }
}
