package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopsRepo extends JpaRepository<Laptops, Long> {

    List<Laptops> findByManufacturer(String manufacturer);
    List<Laptops> findByModel(String name);
    List<Laptops> findByMonitor(Integer monitor);
    List<Laptops> findByCpu(String cpu);
    List<Laptops> findByRam(Integer ram);
    List<Laptops> findByStorageType(String storageType);
    List<Laptops> findByStorageSize(Integer storageSize);
    List<Laptops> findByVideoCard(String videoCard);

    List<Laptops> findByPriceBetween(double price1, double price2);
    List<Laptops> findByPrice(double price1);

}
