package com.sivak.computershop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TabletsIndexController {

    @GetMapping("/tabletsIndex")
    public String tabletsIndex() {

        return "tabletsIndex";
    }
}
