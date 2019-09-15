package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

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
            @Valid Users user,
            BindingResult bindingResult,
            @RequestParam String password2,
            Model model) {

        if (user != null) {
            model.addAttribute("userRegistration", user);
        }

        userService.matchPasswords(user.getPassword(), password2, bindingResult);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = ControllerUtils.getErrorMap(bindingResult);

            model.mergeAttributes(errorMap);

            return "registration";
        } else {

            if (!userService.matchMails(user.getEmail())) {
                model.addAttribute("message", "This mail address already registered");
                return "registration";
            }

            if (!userService.addNewUser(user)) {
                model.addAttribute("message", "A user already exists");
                return "registration";
            }

            model.addAttribute("message", "Please, check you email.");
        }

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
    public String passwordRecovery(@RequestParam String email, Model model) {

        if (!userService.passwordRecoverySend(email)) {

            model.addAttribute("message", "Incorrect email or user isn't exist.");
        }

        model.addAttribute("message", "Please, check your email.");

        return "message";
    }
}
