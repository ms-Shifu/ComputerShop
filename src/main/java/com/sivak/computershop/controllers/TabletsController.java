package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.TabletsRepo;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.TabletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class TabletsController {

    @Autowired
    private TabletsRepo tabletsRepo;

    @Autowired
    private TabletsService tabletsService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/tablets")
    public String filter(
            @RequestParam(required = false) List<String> os,
            @RequestParam(required = false) List<Integer> monitor,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String cpu,
            @RequestParam(required = false) List<Integer> ram,
            @RequestParam(required = false) List<Boolean> flashCard,
            @RequestParam(required = false) List<Integer> storageSize,
            @RequestParam(required = false) List<String> videoCard,
            @RequestParam(required = false, defaultValue = "0.01") double price1,
            @RequestParam(required = false, defaultValue = "99999.99") double price2,
            Model model) {


        List<Tablets> tablets = tabletsService.filter(os, monitor, manufacturer, cpu, ram, flashCard,
                storageSize, videoCard, price1, price2);

        model.addAttribute("classType", "tablets");
        model.addAttribute("tablets", tablets);

        return "tablets";
    }


    @GetMapping("/tabletsEdit")
    public String tabletEdit(Model model) {

        List<Tablets> tablets = tabletsRepo.findAll();
        model.addAttribute("tablets", tablets);

        return "tabletsEdit";
    }

    @PostMapping("/tabletsEditAdd")
    public String addLaptop(@RequestParam String os,
                            @RequestParam String manufacturer,
                            @RequestParam String model,
                            @RequestParam int monitor,
                            @RequestParam String cpu,
                            @RequestParam int ram,
                            @RequestParam boolean flashCard,
                            @RequestParam int storageSize,
                            @RequestParam String videoCard,
                            @RequestParam double price,
                            @RequestParam("file")MultipartFile file) throws IOException {

        Tablets tablet = new Tablets(os, manufacturer, model, monitor, cpu, ram, flashCard,
                storageSize, videoCard, price);

        tabletsService.saveTablet(tablet, file);

        return "redirect:/tabletsEdit";
    }

    @PostMapping("/tabletsEditDelete")
    public String tabletsEditDelete(@RequestParam("id") Tablets tablet,
                                    @RequestParam String buttonEdit,
                                    @RequestParam String os,
                                    @RequestParam String manufacturer,
                                    @RequestParam String model,
                                    @RequestParam int monitor,
                                    @RequestParam String cpu,
                                    @RequestParam int ram,
                                    @RequestParam boolean flashCard,
                                    @RequestParam int storageSize,
                                    @RequestParam String videoCard,
                                    @RequestParam double price
    ) {

        tabletsService.tabletEditOrDelete(tablet, buttonEdit, os, manufacturer, model,
                monitor, cpu, ram, flashCard, storageSize, videoCard, price);

        return "redirect:/tabletsEdit";
    }


//    @GetMapping("/indexAdmin")
//    public String indexAdmin() {
//
//        return "redirect:/";
//    }



    @PostMapping("/addTabletToCart")
    public String addToCart(
            @AuthenticationPrincipal Users user,
            @RequestParam("buttonAddTabletToCart") Tablets tablet
    ) {

        user.getTablets().add(tablet);
        userRepo.save(user);

        return "redirect:/tablets";
    }
}
