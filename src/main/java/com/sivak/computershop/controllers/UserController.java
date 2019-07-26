package com.sivak.computershop.controllers;

import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {

        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(
            @RequestParam String username,
            @RequestParam String password1,
            @RequestParam String password2,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            Model model) {

        if (!userService.matchPasswords(password1, password2)) {
            model.addAttribute("message", "Passwords don't match");
            return "registration";
        }

        if (!userService.addNewUser(username, password1, address, phoneNumber)) {
            model.addAttribute("message", "A user already exists");
            return "registration";
        }

        return "redirect:/login";
    }
}
