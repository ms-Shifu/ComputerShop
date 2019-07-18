package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Roles;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class UserController {
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
            @RequestParam String address,
            @RequestParam String phoneNumber,
            Model model) {

        Users userFromDB = userRepo.findByUsername(username);

        if (userFromDB != null) {
            model.addAttribute("message", "A user already exists");
            return "registration";
        }

        if (!password1.equals(password2)) {
            model.addAttribute("message", "Passwords don't match");
            return "registration";
        }

        Users user = new Users(username, password1, address, phoneNumber);
        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
