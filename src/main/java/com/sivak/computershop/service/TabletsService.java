package com.sivak.computershop.service;

import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.repos.TabletsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TabletsService {
    
    @Autowired
    private TabletsRepo tabletsRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public List<Tablets> filter(List<String> os, List<Integer> monitor, String manufacturer, String cpu,
                                List<Integer> ram, List<Boolean> flashCard, List<Integer> storageSize,
                                List<String> videoCard, double price1, double price2) {

        List<Tablets> tablets = new ArrayList<>();

        if (monitor != null || manufacturer != null || cpu != null || ram != null || flashCard != null ||
                storageSize != null || videoCard != null || price1 != 0 || price2 != 0) {

//---------OS

            if (os != null) {
                for (String o : os) {
                    tablets.addAll(tabletsRepo.findByOs(o));
                }

                if (tablets.isEmpty()) return tablets;
            }

//----------MONITOR

            if (monitor != null) {

                if (tablets.isEmpty()) {
                    for (Integer m : monitor) {
                        tablets.addAll(tabletsRepo.findByMonitor(m));
                    }

                    if (tablets.isEmpty()) return tablets;

                } else {

                    List<Tablets> tabletsEmpty = new ArrayList<>();

                    for (int m : monitor) {
                        tabletsEmpty.addAll(tablets.stream()
                                .filter(l -> (l.getMonitor() == m))
                                .collect(Collectors.toList()));
                    }

                    if (tabletsEmpty.isEmpty()) {
                        return tabletsEmpty;
                    } else {
                        tablets = tabletsEmpty;
                    }
                }
            }

//----------MANUFACTURER

            if (manufacturer != null) {

                if (tablets.isEmpty()) {
                    tablets.addAll(tabletsRepo.findByManufacturer(manufacturer.toUpperCase()));
                } else {
                    tablets = tablets.stream()
                            .filter(l -> l.getManufacturer().equals(manufacturer.toUpperCase()))
                            .collect(Collectors.toList());
                }

                if (tablets.isEmpty()) return tablets;
            }

//----------CPU

            if (cpu != null) {

                if (tablets.isEmpty()) {
                    tablets.addAll(tabletsRepo.findByCpu(cpu));
                } else {
                    tablets = tablets.stream()
                            .filter(l -> l.getCpu().equals(cpu))
                            .collect(Collectors.toList());
                }

                if (tablets.isEmpty()) return tablets;
            }

//----------RAM

            if (ram != null) {

                if (tablets.isEmpty()) {
                    for (Integer r : ram) {
                        tablets.addAll(tabletsRepo.findByRam(r));
                    }

                    if (tablets.isEmpty()) return tablets;

                } else {

                    List<Tablets> tabletsEmpty = new ArrayList<>();

                    for (int r : ram) {
                        tabletsEmpty.addAll(tablets.stream()
                                .filter(l -> (l.getRam() == r))
                                .collect(Collectors.toList()));
                    }

                    if (tabletsEmpty.isEmpty()) {
                        return tabletsEmpty;
                    } else {
                        tablets = tabletsEmpty;
                    }
                }
            }

//----------FLASH_CARD

            if (flashCard != null) {

                if (tablets.isEmpty()) {
                    for (Boolean f : flashCard) {
                        tablets.addAll(tabletsRepo.findByFlashCard(f));
                    }

                    if (tablets.isEmpty()) return tablets;
                } else {

                    List<Tablets> tabletsEmpty = new ArrayList<>();

                    for (Boolean f : flashCard) {
                        tabletsEmpty.addAll(tablets.stream()
                                .filter(l -> ((Boolean)l.isFlashCard()).equals(f))
                                .collect(Collectors.toList()));
                    }

                    if (tabletsEmpty.isEmpty()) {
                        return tabletsEmpty;
                    } else {
                        tablets = tabletsEmpty;
                    }
                }
            }

//----------STORAGE_SIZE

            if (storageSize != null) {

                if (tablets.isEmpty()) {
                    for (Integer s : storageSize) {
                        tablets.addAll(tabletsRepo.findByStorageSize(s));
                    }

                    if (tablets.isEmpty()) return tablets;

                } else {

                    List<Tablets> tabletsEmpty = new ArrayList<>();

                    for (int s : storageSize) {
                        tabletsEmpty.addAll(tablets.stream()
                                .filter(l -> (l.getStorageSize() == s))
                                .collect(Collectors.toList()));
                    }

                    if (tabletsEmpty.isEmpty()) {
                        return tabletsEmpty;
                    } else {
                        tablets = tabletsEmpty;
                    }
                }
            }

//----------VIDEO_CARD

            if (videoCard != null) {

                if (tablets.isEmpty()) {
                    for (String v : videoCard) {
                        tablets.addAll(tabletsRepo.findByVideoCard(v));
                    }

                    if (tablets.isEmpty()) return tablets;
                } else {

                    List<Tablets> tabletsEmpty = new ArrayList<>();

                    for (String v : videoCard) {
                        tabletsEmpty.addAll(tablets.stream()
                                .filter(l -> l.getVideoCard().equals(v))
                                .collect(Collectors.toList()));
                    }

                    if (tabletsEmpty.isEmpty()) {
                        return tabletsEmpty;
                    } else {
                        tablets = tabletsEmpty;
                    }
                }
            }

//----------PRICE

            if (price1 != 0 || price2 != 0) {

                if (tablets.isEmpty()) {
                    tablets.addAll(tabletsRepo.findByPriceBetween(price1, price2));
                } else {
                    tablets = tablets.stream()
                            .filter(p -> (p.getPrice() >= price1 && p.getPrice() <= price2))
                            .collect(Collectors.toList());
                }

                if (tablets.isEmpty()) return tablets;
            }

        } else {
            return tabletsRepo.findAll();
        }

        return tablets;
    }


    public void saveTablet(Tablets tablet, MultipartFile file) throws IOException {

        File uploadsFile = new File(uploadPath);

        if (!uploadsFile.exists()) {
            uploadsFile.mkdir();
        }

        String uuidName = UUID.randomUUID().toString();
        String resultFileName = uuidName + "." + file.getOriginalFilename();
        tablet.setFileName(resultFileName);

        file.transferTo(new File(uploadPath + "/" + resultFileName));

        tabletsRepo.save(tablet);
    }

    public void tabletEditOrDelete(Tablets tablet, String buttonEdit, String os, String manufacturer,
                                   String model, int monitor, String cpu, int ram, boolean flashCard,
                                   int storageSize, String videoCard, double price) {

        if (buttonEdit.equals("edit")) {

            tablet.setOs(os);
            tablet.setManufacturer(manufacturer);
            tablet.setModel(model);
            tablet.setMonitor(monitor);
            tablet.setCpu(cpu);
            tablet.setRam(ram);
            tablet.setFlashCard(flashCard);
            tablet.setStorageSize(storageSize);
            tablet.setVideoCard(videoCard);
            tablet.setPrice(price);

            tabletsRepo.save(tablet);
        } else {
            tabletsRepo.delete(tablet);
        }

    }
}
