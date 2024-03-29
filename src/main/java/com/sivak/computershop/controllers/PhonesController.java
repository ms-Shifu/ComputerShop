package com.sivak.computershop.controllers;


import com.sivak.computershop.entities.Phones;
import com.sivak.computershop.entities.Products;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.entities.comparators.ProductPriceAscComparator;
import com.sivak.computershop.entities.comparators.ProductsPriceDescComparator;
import com.sivak.computershop.repos.PhonesRepo;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.PhonesService;
import com.sivak.computershop.service.ProductsService;
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
public class PhonesController {

    @Autowired
    private PhonesService phonesService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private PhonesRepo phonesRepo;

    @GetMapping("/phones")
    public String phones(
            @RequestParam(required = false) List<Boolean> dualSim,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) List<Integer> monitor,
            @RequestParam(required = false) String cpu,
            @RequestParam(required = false) List<Integer> ram,
            @RequestParam(required = false) List<Integer> storageSize,
            @RequestParam(required = false) List<Boolean> flashCard,
            @RequestParam(required = false, defaultValue = "0") Double price1,
            @RequestParam(required = false, defaultValue = "0") Double price2,
            @RequestParam(defaultValue = "true") boolean sortByPrice,
            Model model) {

        List<Phones> phones = phonesService.filter(dualSim, monitor, manufacturer, cpu, ram, flashCard, storageSize, price1, price2);

        Comparator<Products> pcomp;

        if (sortByPrice) {
            pcomp = new ProductPriceAscComparator();
        } else {
            pcomp = new ProductsPriceDescComparator();
        }

        phones.sort(pcomp);

        model.addAttribute("classType", "phones");
        model.addAttribute("phones", phones);

        model.addAttribute("activePhones", "active");
        model.addAttribute("activeCatalog", "active");

        ControllerUtils.addCheckedPhonesToViewLayer(
                dualSim, manufacturer, monitor, cpu, ram, storageSize, flashCard, price1, price2, model
        );

        return "phones";
    }

    @PostMapping("/addPhoneToCart")
    public String addToCart(
            @RequestParam("userId") Users user,
            @RequestParam("buttonAddPhoneToCart") Phones phone,
            @AuthenticationPrincipal Users userSession
    ) {

        user.getPhones().add(phone);
        userRepo.save(user);

        userSession.getPhones().add(phone);

        return "redirect:/phones";
    }

    @GetMapping("/phonesEdit")
    public String phoneEdit(Model model) {

        Sort sortOrder = Sort.by("id");

        List<Phones> phones = phonesRepo.findAll(sortOrder);
        model.addAttribute("phones", phones);

        return "phonesEdit";
    }

    @PostMapping("/phonesEditAdd")
    public String addPhone(@RequestParam String manufacturer,
                            @RequestParam String model,
                            @RequestParam int monitor,
                            @RequestParam String cpu,
                            @RequestParam int ram,
                            @RequestParam int storageSize,
                            @RequestParam boolean flashCard,
                            @RequestParam boolean dualSim,
                            @RequestParam double price,
                            @RequestParam("file") MultipartFile file) throws IOException {

        Phones phone = new Phones(manufacturer, model, monitor, cpu, ram,
                storageSize, flashCard, dualSim, price);

        productsService.saveProduct(phone, file);

        return "redirect:/phonesEdit";
    }

    @PostMapping("/phonesEditDelete")
    public String phonesEditDelete(@RequestParam("id") Phones phone,
                                    @RequestParam String buttonEdit,
                                    @RequestParam String manufacturer,
                                    @RequestParam String model,
                                    @RequestParam int monitor,
                                    @RequestParam String cpu,
                                    @RequestParam int ram,
                                    @RequestParam int storageSize,
                                    @RequestParam boolean flashCard,
                                    @RequestParam boolean dualSim,
                                    @RequestParam double price
    ) {

        phonesService.phoneEditOrDelete(phone, buttonEdit, manufacturer, model,
                monitor, cpu, ram, storageSize, flashCard,  dualSim, price);

        return "redirect:/phonesEdit";
    }

    @GetMapping("/phones/{phone}")
    public String phoneOptions(
            @PathVariable Phones phone,
            Model model
    ) {

        model.addAttribute("phone", phone);

        return "phoneOptions";
    }

}
