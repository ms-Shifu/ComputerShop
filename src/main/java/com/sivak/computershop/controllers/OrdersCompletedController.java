package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.OrdersCompleted;
import com.sivak.computershop.repos.OrdersCompletedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersCompletedController {

    @Autowired
    private OrdersCompletedRepo ordersCompletedRepo;

    @GetMapping("/ordersCompleted")
    public String ordersCompleted(Model model) {

        List<OrdersCompleted> ordersCompleted = ordersCompletedRepo.findAll();
        model.addAttribute("ordersCompleted", ordersCompleted);

        model.addAttribute("activeOrdersCompleted", "active");


        return "ordersCompleted";
    }
}
