package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.*;
import com.sivak.computershop.repos.OrdersRepo;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping("/cart")
    public String cart(
            @AuthenticationPrincipal Users userSession,
            Model model
    ) {

        Users userFromDB = userRepo.findByUsername(userSession.getUsername());
        model.addAttribute("laptops", userFromDB.getLaptops());
        model.addAttribute("tablets", userFromDB.getTablets());
        model.addAttribute("phones", userFromDB.getPhones());
//        model.addAttribute("getInCart", userFromDB.getInCart());

        return "cart";
    }

    @PostMapping("/buy")
    public String buy(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "laptopId", required = false) Laptops laptop,
            @RequestParam(value = "tabletId", required = false) Tablets tablet,
            @RequestParam(value = "phoneId", required = false) Phones phone,
            @AuthenticationPrincipal Users userSession

//            @RequestParam(required = false, defaultValue = "false") boolean isAddAll
    ) {
//
//        if (isAddAll) {
//            laptops = user.getLaptops();
//            tablets = user.getTablets();
//            phones = user.getPhones();
//        }

        Users user = userRepo.findByUsername(username);

        Orders order = new Orders(user);

        if (laptop != null) {
            order.getLaptops().add(laptop);
        }

        if (tablet != null) {
            order.getTablets().add(tablet);
        }

        if (phone != null) {
            order.getPhones().add(phone);
        }


        if (laptop != null || tablet != null || phone != null) {
            removeFromCart(username, laptop, tablet, phone, userSession);
        }


        ordersRepo.save(order);

        return "redirect:/cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(
            @RequestParam("username") String username,
            @RequestParam(value = "laptopId", required = false) Laptops laptop,
            @RequestParam(value = "tabletId", required = false) Tablets tablet,
            @RequestParam(value = "phoneId", required = false) Phones phone,
            @AuthenticationPrincipal Users userSession

            ) {

        Users user = userRepo.findByUsername(username);

        if (laptop != null) {
            user.getLaptops().remove(laptop);
            userSession.getLaptops().remove(laptop);
        }

        if (tablet != null) {
            user.getTablets().remove(tablet);
            userSession.getTablets().remove(tablet);
        }

        if (phone != null) {
            user.getPhones().remove(phone);
            userSession.getPhones().remove(phone);
        }

        userRepo.save(user);

        return "redirect:/cart";
    }

    @PostMapping("/buyAll")
    public String buyAll(@RequestParam("username") String username,
                         @RequestParam(required = false) String paymentMethod,
                         @RequestParam(required = false) String  totalPrice,
                         @AuthenticationPrincipal Users userSession,
                         Model model) {

        Users user = userRepo.findByUsername(username);

        Orders order = new Orders(user);

        order.getLaptops().addAll(user.getLaptops());
        user.getLaptops().clear();
        userSession.getLaptops().clear();

        order.getTablets().addAll(user.getTablets());
        user.getTablets().clear();
        userSession.getTablets().clear();

        order.getPhones().addAll(user.getPhones());
        user.getPhones().clear();
        userSession.getPhones().clear();

        ordersRepo.save(order);
    
        Double totalPriceDouble = Double.valueOf(totalPrice);
    
        if (paymentMethod.equals("payOnline")) {
            model.addAttribute("totalPrice", totalPriceDouble);
            model.addAttribute("orderId", order.getId());
            return "payment";
        }

        return "redirect:/cart";
    }
}
