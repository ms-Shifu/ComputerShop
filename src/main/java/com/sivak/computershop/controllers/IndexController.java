package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.repos.LaptopsRepo;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class IndexController {
//    @Autowired
//    private LaptopsRepo laptopsRepo;

    private final LaptopsRepo laptopsRepo;
    public IndexController(LaptopsRepo laptopsRepo) {
        this.laptopsRepo = laptopsRepo;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/laptopsEdit")
    public String laptopEdit(Model model) {

        return "laptopsEdit";
    }

    @PostMapping("/laptopsEdit")
    public String addLaptop(Model model2,
                            @RequestParam String manufacturer,
                            @RequestParam String model,
                            @RequestParam int monitor,
                            @RequestParam String cpu,
                            @RequestParam int ram,
                            @RequestParam String storageType,
                            @RequestParam int storageSize,
                            @RequestParam String videoCard,
                            @RequestParam("file")MultipartFile file
                            ) throws IOException {

        Laptops laptop = new Laptops(manufacturer,model, monitor, cpu, ram, storageType,
                storageSize, videoCard);

        File uploadsFile = new File(uploadPath);

        if (!uploadsFile.exists()) {
            uploadsFile.mkdir();
        }

        String uuidName = UUID.randomUUID().toString();
        String resultFileName = uuidName + "." + file.getOriginalFilename();
        laptop.setFileName(resultFileName);

        file.transferTo(new File(uploadPath + "/" + resultFileName));

        laptopsRepo.save(laptop);

        return "/laptopsEdit";
    }
}
