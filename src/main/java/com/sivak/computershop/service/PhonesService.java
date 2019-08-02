package com.sivak.computershop.service;

import com.sivak.computershop.entities.Phones;
import com.sivak.computershop.repos.PhonesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhonesService {
    @Autowired
    private PhonesRepo phonesRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public List<Phones> filter(List<Boolean> dualSim, List<Integer> monitor,
                               String manufacturer, String cpu, List<Integer> ram,
                               List<Boolean> flashCard, List<Integer> storageSize,
                               double price1, double price2) {

        List<Phones> phones = new ArrayList<>();

        if (monitor != null || manufacturer != null || cpu != null || ram != null || flashCard != null ||
                storageSize != null || price1 != 0 || price2 != 0) {

//---------DualSIM

            if (dualSim != null) {
                for (boolean d : dualSim) {
                    phones.addAll(phonesRepo.findByDualSim(d));
                }

                if (phones.isEmpty()) return phones;
            }

//----------MONITOR

            if (monitor != null) {

                if (phones.isEmpty()) {
                    for (Integer m : monitor) {
                        phones.addAll(phonesRepo.findByMonitor(m));
                    }

                    if (phones.isEmpty()) return phones;

                } else {

                    List<Phones> phonesEmpty = new ArrayList<>();

                    for (int m : monitor) {
                        phonesEmpty.addAll(phones.stream()
                                .filter(l -> (l.getMonitor() == m))
                                .collect(Collectors.toList()));
                    }

                    if (phonesEmpty.isEmpty()) {
                        return phonesEmpty;
                    } else {
                        phones = phonesEmpty;
                    }
                }
            }

//----------MANUFACTURER

            if (manufacturer != null) {

                if (phones.isEmpty()) {
                    phones.addAll(phonesRepo.findByManufacturer(manufacturer.toUpperCase()));
                } else {
                    phones = phones.stream()
                            .filter(l -> l.getManufacturer().equals(manufacturer.toUpperCase()))
                            .collect(Collectors.toList());
                }

                if (phones.isEmpty()) return phones;
            }

//----------CPU

            if (cpu != null) {

                if (phones.isEmpty()) {
                    phones.addAll(phonesRepo.findByCpu(cpu));
                } else {
                    phones = phones.stream()
                            .filter(l -> l.getCpu().equals(cpu))
                            .collect(Collectors.toList());
                }

                if (phones.isEmpty()) return phones;
            }

//----------RAM

            if (ram != null) {

                if (phones.isEmpty()) {
                    for (Integer r : ram) {
                        phones.addAll(phonesRepo.findByRam(r));
                    }

                    if (phones.isEmpty()) return phones;

                } else {

                    List<Phones> phonesEmpty = new ArrayList<>();

                    for (int r : ram) {
                        phonesEmpty.addAll(phones.stream()
                                .filter(l -> (l.getRam() == r))
                                .collect(Collectors.toList()));
                    }

                    if (phonesEmpty.isEmpty()) {
                        return phonesEmpty;
                    } else {
                        phones = phonesEmpty;
                    }
                }
            }

//----------FLASH_CARD

            if (flashCard != null) {

                if (phones.isEmpty()) {
                    for (Boolean f : flashCard) {
                        phones.addAll(phonesRepo.findByFlashCard(f));
                    }

                    if (phones.isEmpty()) return phones;
                } else {

                    List<Phones> phonesEmpty = new ArrayList<>();

                    for (Boolean f : flashCard) {
                        phonesEmpty.addAll(phones.stream()
                                .filter(l -> ((Boolean)l.isFlashCard()).equals(f))
                                .collect(Collectors.toList()));
                    }

                    if (phonesEmpty.isEmpty()) {
                        return phonesEmpty;
                    } else {
                        phones = phonesEmpty;
                    }
                }
            }

//----------STORAGE_SIZE

            if (storageSize != null) {

                if (phones.isEmpty()) {
                    for (Integer s : storageSize) {
                        phones.addAll(phonesRepo.findByStorageSize(s));
                    }

                    if (phones.isEmpty()) return phones;

                } else {

                    List<Phones> phonesEmpty = new ArrayList<>();

                    for (int s : storageSize) {
                        phonesEmpty.addAll(phones.stream()
                                .filter(l -> (l.getStorageSize() == s))
                                .collect(Collectors.toList()));
                    }

                    if (phonesEmpty.isEmpty()) {
                        return phonesEmpty;
                    } else {
                        phones = phonesEmpty;
                    }
                }
            }

//----------PRICE

            if (price1 != 0 || price2 != 0) {

                if (phones.isEmpty()) {
                    phones.addAll(phonesRepo.findByPriceBetween(price1, price2));
                } else {
                    phones = phones.stream()
                            .filter(p -> (p.getPrice() >= price1 && p.getPrice() <= price2))
                            .collect(Collectors.toList());
                }

                if (phones.isEmpty()) return phones;
            }

        } else {
            return phonesRepo.findAll();
        }

        return phones;
    }

    public void phoneEditOrDelete(Phones phone, String buttonEdit, String manufacturer,
                                   String model, int monitor, String cpu, int ram, int storageSize,
                                  boolean flashCard, boolean dualSim,  double price) {

        if (buttonEdit.equals("edit")) {

            phone.setManufacturer(manufacturer);
            phone.setModel(model);
            phone.setMonitor(monitor);
            phone.setCpu(cpu);
            phone.setRam(ram);
            phone.setStorageSize(storageSize);
            phone.setFlashCard(flashCard);
            phone.setDualSim(dualSim);
            phone.setPrice(price);

            phonesRepo.save(phone);
        } else {
            phonesRepo.delete(phone);
        }

    }
}
