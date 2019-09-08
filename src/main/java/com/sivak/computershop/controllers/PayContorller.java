package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Orders;
import com.sivak.computershop.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

//@RestController
@Controller
public class PayContorller {
    
    @Autowired
    private OrdersRepo ordersRepo;
    
    //    @RequestMapping(value = "/payed", method = RequestMethod.POST)
    @PostMapping("/payed")
    public void payCompleted(@RequestParam Map<String, String> payed) {
    
        String id = payed.get("label");
        Optional<Orders> orders = ordersRepo.findById(Long.valueOf(id));
        Orders order = orders.get();
        order.setPayed(true);
        ordersRepo.save(order);
    }
}
