package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LaptopsRepo extends JpaRepository {
    Iterable<Laptops> findByManufacturer(String manufacturer);
    Iterable<Laptops> findByModel(String name);
    Iterable<Laptops> findByMonitor(int monitor);
    Iterable<Laptops> findByCpu(String cpu);
    Iterable<Laptops> findByRam(int ram);
    Iterable<Laptops> findByStorageType(String storageType);
    Iterable<Laptops> findByStorageSize(int storageSize);
    Iterable<Laptops> findByVideoCard(String videoCard);
}
