package com.sivak.computershop.service;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.repos.LaptopsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopsService {

    @Autowired
    private LaptopsRepo laptopsRepo;



    public List<Laptops> filter(List<Integer> monitor, String manufacturer, String cpu, List<Integer> ram,
                                List<String> storageType, List<Integer> storageSize, List<String> videoCard,
                                double price1, double price2) {

        List<Laptops> laptops = new ArrayList<>();

        if (monitor != null || manufacturer != null || cpu != null || ram != null || storageType != null ||
                storageSize != null || videoCard != null || price1 != 0 || price2 != 0) {

//----------MONITOR

            if (monitor != null) {
                for (Integer m : monitor) {
                    laptops.addAll(laptopsRepo.findByMonitor(m));
                }

                if (laptops.isEmpty()) return laptops;
            }

//----------MANUFACTURER

            if (manufacturer != null) {

                if (laptops.isEmpty()) {
                    laptops.addAll(laptopsRepo.findByManufacturer(manufacturer.toUpperCase()));
                } else {
                    laptops = laptops.stream()
                            .filter(l -> l.getManufacturer().equals(manufacturer.toUpperCase()))
                            .collect(Collectors.toList());
                }

                if (laptops.isEmpty()) return laptops;
            }

//----------CPU

            if (cpu != null) {

                if (laptops.isEmpty()) {
                    laptops.addAll(laptopsRepo.findByCpu(cpu));
                } else {
                    laptops = laptops.stream()
                            .filter(l -> l.getCpu().equals(cpu))
                            .collect(Collectors.toList());
                }

                if (laptops.isEmpty()) return laptops;
            }

//----------RAM

            if (ram != null) {

                if (laptops.isEmpty()) {
                    for (Integer r : ram) {
                        laptops.addAll(laptopsRepo.findByRam(r));
                    }

                    if (laptops.isEmpty()) return laptops;

                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (int r : ram) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l -> (l.getRam() == r))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        return laptopsEmpty;
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

                    if (laptops.isEmpty()) return laptops;
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (String s : storageType) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l -> l.getStorageType().equals(s))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        return laptopsEmpty;
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

                    if (laptops.isEmpty()) return laptops;
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (int s : storageSize) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l -> (l.getStorageSize() == s))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        return laptopsEmpty;
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

                    if (laptops.isEmpty()) return laptops;
                } else {

                    List<Laptops> laptopsEmpty = new ArrayList<>();

                    for (String v : videoCard) {
                        laptopsEmpty.addAll(laptops.stream()
                                .filter(l -> l.getVideoCard().equals(v))
                                .collect(Collectors.toList()));
                    }

                    if (laptopsEmpty.isEmpty()) {
                        return laptopsEmpty;
                    } else {
                        laptops = laptopsEmpty;
                    }
                }
            }

//----------PRICE

            if (price1 != 0 || price2 != 0) {

                if (laptops.isEmpty()) {
                    laptops.addAll(laptopsRepo.findByPriceBetween(price1, price2));
                } else {
                    laptops = laptops.stream()
                            .filter(p -> (p.getPrice() >= price1 && p.getPrice() <= price2))
                            .collect(Collectors.toList());
                }

                if (laptops.isEmpty()) return laptops;
            }

        } else {
            return laptopsRepo.findAll();
        }

        return laptops;
    }


    public void laptopEditOrDelete(Laptops laptop, String buttonEdit, String manufacturer,
                                   String model, int monitor, String cpu, int ram,
                                   String storageType, int storageSize, String videoCard,
                                   double price) {

        if (buttonEdit.equals("edit")) {

            laptop.setManufacturer(manufacturer);
            laptop.setModel(model);
            laptop.setMonitor(monitor);
            laptop.setCpu(cpu);
            laptop.setRam(ram);
            laptop.setStorageType(storageType);
            laptop.setStorageSize(storageSize);
            laptop.setVideoCard(videoCard);
            laptop.setPrice(price);

            laptopsRepo.save(laptop);
        } else {
            laptopsRepo.delete(laptop);
        }

    }

}
