package com.sivak.computershop.controllers;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.repos.LaptopsRepo;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    @Autowired
    private LaptopsRepo laptopsRepo;

//    private final LaptopsRepo laptopsRepo;
//    public IndexController(LaptopsRepo laptopsRepo) {
//        this.laptopsRepo = laptopsRepo;
//    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String filter(
            @RequestParam(required = false) List<Integer> monitor,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String cpu,
            @RequestParam(required = false) List<Integer> ram,
            @RequestParam(required = false) List<String> storageType,
            @RequestParam(required = false) List<Integer> storageSize,
            @RequestParam(required = false) List<String> videoCard,
            Model model) {

        List<Laptops> laptops = new ArrayList<>();

        if (monitor != null || manufacturer != null || cpu != null || ram != null || storageType != null ||
                storageSize != null || videoCard != null) {

//            List<Laptops> laptopsEmpty = new ArrayList<>();

//----------MONITOR

            if (monitor != null) {
                for (Integer m : monitor) {
                    laptops.addAll(laptopsRepo.findByMonitor(m));
                }

                if (laptops.isEmpty()) {
                    model.addAttribute("laptops", laptops);
                    return "index";
                }
            }

//----------MANUFACTURER

            if (manufacturer != null) {

                if (laptops.isEmpty()) {
                    laptops.addAll(laptopsRepo.findByManufacturer(manufacturer));
                } else {
                    laptops = laptops.stream()
                            .filter(l->l.getManufacturer().equals(manufacturer))
                            .collect(Collectors.toList());
                }

                if (laptops.isEmpty()) {
                    model.addAttribute("laptops", laptops);
                    return "index";
                }
            }

//----------CPU

            if (cpu != null) {

                if (laptops.isEmpty()) {
                    laptops.addAll(laptopsRepo.findByCpu(cpu));
                } else {
                    laptops = laptops.stream()
                            .filter(l->l.getCpu().equals(cpu))
                            .collect(Collectors.toList());
                }

                if (laptops.isEmpty()) {
                    model.addAttribute("laptops", laptops);
                    return "index";
                }
            }

//----------RAM

            if (ram != null) {

                if (laptops.isEmpty()) {
                    for (Integer r : ram) {
                        laptops.addAll(laptopsRepo.findByRam(r));
                    }

                    if (laptops.isEmpty()) {
                        model.addAttribute("laptops", laptops);
                        return "index";
                    }
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (int r : ram) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l-> (l.getRam() == r))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        model.addAttribute("laptops", laptopsEmpty);
                        return "index";
                    } else {
                        laptops = laptopsEmpty;
                    }
                }
            }

//----------STORAGE_TYPE

            if (storageType != null) {

                if (laptops.isEmpty()) {
                    for (String s : storageType) {
                        laptops.addAll(laptopsRepo.findByStorageType(s));
                    }

                    if (laptops.isEmpty()) {
                        model.addAttribute("laptops", laptops);
                        return "index";
                    }
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (String s : storageType) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l-> l.getStorageType().equals(s))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        model.addAttribute("laptops", laptopsEmpty);
                        return "index";
                    } else {
                       laptops = laptopsEmpty;
                    }
                }
            }

//----------STORAGE_SIZE

            if (storageSize != null) {

                if (laptops.isEmpty()) {
                    for (Integer s : storageSize) {
                        laptops.addAll(laptopsRepo.findByStorageSize(s));
                        }

                    if (laptops.isEmpty()) {
                        model.addAttribute("laptops", laptops);
                        return "index";
                    }
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (int s : storageSize) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l-> (l.getStorageSize() == s))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        model.addAttribute("laptops", laptopsEmpty);
                        return "index";
                    } else {
                        laptops = laptopsEmpty;
                    }
                }
            }

//----------VIDEO_CARD

            if (videoCard != null) {

                if (laptops.isEmpty()) {
                    for (String v : videoCard) {
                        laptops.addAll(laptopsRepo.findByVideoCard(v));
                    }

                    if (laptops.isEmpty()) {
                        model.addAttribute("laptops", laptops);
                        return "index";
                    }
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (String v : videoCard) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l-> l.getVideoCard().equals(v))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        model.addAttribute("laptops", laptopsEmpty);
                        return "index";
                    } else {
                        laptops = laptopsEmpty;
                    }
                }
            }

        } else {
            laptops = laptopsRepo.findAll();
        }


        model.addAttribute("laptops", laptops);

        return "index";
    }


    @GetMapping("/laptopsEdit")
    public String laptopEdit(Model model) {

        List<Laptops> laptops = laptopsRepo.findAll();
        model.addAttribute("laptops", laptops);

        return "laptopsEdit";
    }

    @PostMapping("/laptopsEditAdd")
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
                                    @RequestParam String videoCard
    ) {

        if (buttonEdit.equals("edit")) {
            laptop.setManufacturer(manufacturer);
            laptop.setModel(model);
            laptop.setMonitor(monitor);
            laptop.setCpu(cpu);
            laptop.setRam(ram);
            laptop.setStorageType(storageType);
            laptop.setStorageSize(storageSize);
            laptop.setVideoCard(videoCard);

            laptopsRepo.save(laptop);
        } else {
            laptopsRepo.delete(laptop);
        }

        return "redirect:/laptopsEdit";
    }


    @GetMapping("/indexAdmin")
    public String indexAdmin() {

        return "redirect:/";
    }
}


