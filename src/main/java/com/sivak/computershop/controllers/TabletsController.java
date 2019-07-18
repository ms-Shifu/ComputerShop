package com.sivak.computershop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TabletsController {

    @GetMapping("/tablets")
    public String tabletsIndex() {

        return "tablets";
    }
}
