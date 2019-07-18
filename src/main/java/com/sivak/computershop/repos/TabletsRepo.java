package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Tablets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TabletsRepo extends JpaRepository<Tablets, Long> {
    List<Tablets> findByOs(String os);

    List<Tablets> findByManufacturer(String manufacturer);

    List<Tablets> findByModel(String model);

    List<Tablets> findByMonitor(int monitor);

    List<Tablets> findByCpu(String cpu);

    List<Tablets> findByRam(int ram);

    List<Tablets> findByFlashCard(boolean flashCard);

    List<Tablets> findByStorageSize(Integer storageSize);

    List<Tablets> findByVideoCard(String videoCard);

    List<Tablets> findByPriceBetween(double price1, double price2);

}
