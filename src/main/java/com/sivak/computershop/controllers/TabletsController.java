package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Products;
import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.entities.comparators.ProductPriceAscComparator;
import com.sivak.computershop.entities.comparators.ProductsPriceDescComparator;
import com.sivak.computershop.repos.TabletsRepo;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.ProductsService;
import com.sivak.computershop.service.TabletsService;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Controller
public class TabletsController {

    @Autowired
    private TabletsRepo tabletsRepo;

    @Autowired
    private TabletsService tabletsService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/tablets")
    public String filter(
            @RequestParam(required = false) List<String> os,
            @RequestParam(required = false) List<Integer> monitor,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String cpu,
            @RequestParam(required = false) List<Integer> ram,
            @RequestParam(required = false) List<Boolean> flashCard,
            @RequestParam(required = false) List<Integer> storageSize,
            @RequestParam(required = false, defaultValue = "0.01") double price1,
            @RequestParam(required = false, defaultValue = "99999.99") double price2,
            @RequestParam(defaultValue = "true") boolean sortByPrice,
            Model model) {


        List<Tablets> tablets = tabletsService.filter(os, monitor, manufacturer, cpu, ram, flashCard,
                storageSize, price1, price2);

        Comparator<Products> pcomp;

        if (sortByPrice) {
            pcomp = new ProductPriceAscComparator();
        } else {
            pcomp = new ProductsPriceDescComparator();
        }

        tablets.sort(pcomp);

        model.addAttribute("classType", "tablets");
        model.addAttribute("tablets", tablets);

        model.addAttribute("activeTablets", "active");
        model.addAttribute("activeCatalog", "active");

        return "tablets";
    }


    @GetMapping("/tabletsEdit")
    public String tabletEdit(Model model) {

        Sort sortedOrder = Sort.by("id");

        List<Tablets> tablets = tabletsRepo.findAll(sortedOrder);
        model.addAttribute("tablets", tablets);

        return "tabletsEdit";
    }

    @PostMapping("/tabletsEditAdd")
    public String addTablet(@RequestParam String os,
                            @RequestParam String manufacturer,
                            @RequestParam String model,
                            @RequestParam int monitor,
                            @RequestParam String cpu,
                            @RequestParam int ram,
                            @RequestParam boolean flashCard,
                            @RequestParam int storageSize,
                            @RequestParam double price,
                            @RequestParam("file") MultipartFile file) throws IOException {

        Tablets tablet = new Tablets(os, manufacturer, model, monitor, cpu, ram, flashCard,
                storageSize, price);

        productsService.saveProduct(tablet, file);


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
                                    @RequestParam double price
    ) {

        tabletsService.tabletEditOrDelete(tablet, buttonEdit, os, manufacturer, model,
                monitor, cpu, ram, flashCard, storageSize, price);

        return "redirect:/tabletsEdit";
    }


    @PostMapping("/addTabletToCart")
    public String addToCart(
            @RequestParam("userId") Users user,
            @RequestParam("buttonAddTabletToCart") Tablets tablet,
            @AuthenticationPrincipal Users userSession
    ) {

        user.getTablets().add(tablet);
        userRepo.save(user);

        userSession.getTablets().add(tablet);

        return "redirect:/tablets";
    }

    @GetMapping("/tablets/{tablet}")
    public String tabletsRef(
            @PathVariable Tablets tablet,
            Model model
    ) {

        model.addAttribute("tablet", tablet);

        return "tabletOptions";
    }
}
