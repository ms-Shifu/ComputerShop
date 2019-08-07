package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.entities.Products;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.entities.comparators.ProductPriceAscComparator;
import com.sivak.computershop.entities.comparators.ProductsPriceDescComparator;
import com.sivak.computershop.repos.LaptopsRepo;
import com.sivak.computershop.repos.UserRepo;
import com.sivak.computershop.service.LaptopsService;
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
public class IndexController {

    @Autowired
    private LaptopsRepo laptopsRepo;

    @Autowired
    private LaptopsService laptopsService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/")
    public String filter(
            @RequestParam(required = false) List<Integer> monitor,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String cpu,
            @RequestParam(required = false) List<Integer> ram,
            @RequestParam(required = false) List<String> storageType,
            @RequestParam(required = false) List<Integer> storageSize,
            @RequestParam(required = false) List<String> videoCard,
            @RequestParam(required = false, defaultValue = "0.01") double price1,
            @RequestParam(required = false, defaultValue = "99999.99") double price2,
            @RequestParam(defaultValue = "true") boolean sortByPrice,
            Model model) {


        List<Laptops> laptops = laptopsService.filter(monitor, manufacturer, cpu, ram, storageType,
                storageSize, videoCard, price1, price2);

        Comparator<Products> pcomp;

        if (sortByPrice) {
            pcomp = new ProductPriceAscComparator();
        } else {
            pcomp = new ProductsPriceDescComparator();
        }

        laptops.sort(pcomp);

        model.addAttribute("classType", "laptops");
        model.addAttribute("laptops", laptops);

        model.addAttribute("activeLaptops", "active");
        model.addAttribute("activeCatalog", "active");

        return "index";
    }


    @GetMapping("/laptopsEdit")
    public String laptopEdit(Model model) {

        Sort sortedOrder = Sort.by("id");

        List<Laptops> laptops = laptopsRepo.findAll(sortedOrder);

        model.addAttribute("laptops", laptops);

        return "laptopsEdit";
    }

    @PostMapping("/laptopsEditAdd")
    public String addLaptop(@RequestParam String manufacturer,
                            @RequestParam String model,
                            @RequestParam int monitor,
                            @RequestParam String cpu,
                            @RequestParam int ram,
                            @RequestParam String storageType,
                            @RequestParam int storageSize,
                            @RequestParam String videoCard,
                            @RequestParam double price,
                            @RequestParam("file")MultipartFile file) throws IOException {

        Laptops laptop = new Laptops(manufacturer, model, monitor, cpu, ram, storageType,
                storageSize, videoCard, price);

        productsService.saveProduct(laptop, file);

        return "redirect:/laptopsEdit";
    }

    @PostMapping("/laptopsEditDelete")
    public String laptopsEditDelete(@RequestParam("id") Laptops laptop,
                                    @RequestParam String buttonEdit,
                                    @RequestParam String manufacturer,
                                    @RequestParam String model,
                                    @RequestParam int monitor,
                                    @RequestParam String cpu,
                                    @RequestParam int ram,
                                    @RequestParam String storageType,
                                    @RequestParam int storageSize,
                                    @RequestParam String videoCard,
                                    @RequestParam double price
    ) {

        laptopsService.laptopEditOrDelete(laptop, buttonEdit, manufacturer, model,
                monitor, cpu, ram, storageType, storageSize, videoCard, price);

        return "redirect:/laptopsEdit";
    }


    @GetMapping("/indexAdmin")
    public String indexAdmin() {

        return "redirect:/";
    }



    @PostMapping("/addLaptopToCart")
    public String addToCart(
            @RequestParam("userId") Users user,
            @RequestParam("buttonAddLaptopToCart") Laptops laptop,
            @AuthenticationPrincipal Users userSession
    ) {

        user.getLaptops().add(laptop);
        userRepo.save(user);

        userSession.getLaptops().add(laptop);

        return "redirect:/";
    }

    @GetMapping("/laptops/{laptop}")
    public String laptopsRef(
            @PathVariable Laptops laptop,
            Model model
    ) {

        model.addAttribute("laptop", laptop);

        return "laptopOptions";
    }

}


