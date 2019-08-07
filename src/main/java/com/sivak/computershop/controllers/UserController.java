package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(Model model) {

        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(
            @RequestParam String username,
            @RequestParam String password1,
            @RequestParam String password2,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            Model model) {

        if (!userService.matchPasswords(password1, password2)) {
            model.addAttribute("message", "Passwords don't match");
            return "registration";
        }

        if (!userService.addNewUser(username, password1, email, address, phoneNumber)) {
            model.addAttribute("message", "A user already exists");
            return "registration";
        }
    
        model.addAttribute("message", "Please, check you email.");

        return "message";
    }
    
    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model) {
    
        if (!userService.activate(code)) {
            model.addAttribute("message", "Activation number isn't found");
            return "/login";
        }
    
        model.addAttribute("message2", "Activation completed successfully");
        
        return "/login";
    }
    
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
    
        return "passwordRecovery";
    }
    
    @PostMapping("/passwordRecovery")
    public String passwordRecovery(@RequestParam String email,  Model model) {
    
        if (!userService.passwordRecoverySend(email)) {
    
            model.addAttribute("message", "Incorrect email or user isn't exist.");
        }
    
        model.addAttribute("message", "Please, check your email.");
        
        return "message";
    }
}
