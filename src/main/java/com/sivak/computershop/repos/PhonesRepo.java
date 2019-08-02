package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhonesRepo extends JpaRepository<Phones, Long> {
    List<Phones> findByDualSim(boolean dualSim);

    List<Phones> findByManufacturer(String manufacturer);

    List<Phones> findByModel(String model);

    List<Phones> findByMonitor(int monitor);

    List<Phones> findByCpu(String cpu);

    List<Phones> findByRam(int ram);

    List<Phones> findByStorageSize(Integer storageSize);

    List<Phones> findByFlashCard(boolean flashCard);

    List<Phones> findByPriceBetween(double price1, double price2);

}
