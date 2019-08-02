package com.sivak.computershop.entities;

import javax.persistence.*;

@Entity
public class Laptops implements Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String model;
    private int monitor;
    private String cpu;
    private int ram;
    private String storageType;
    private Integer storageSize;
    private String videoCard;
    private String fileName;
    @Column(precision = 2)
    private double price;


    public Laptops() {
    }

    public Laptops(String manufacturer, String model, int monitor, String cpu, int ram,
                   String storageType, Integer storageSize, String videoCard,
                   double price) {
        this.manufacturer = manufacturer.toUpperCase();
        this.model = model;
        this.monitor = monitor;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.videoCard = videoCard;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer.toUpperCase();
    }

    public int getMonitor() {
        return monitor;
    }

    public void setMonitor(int monitor) {
        this.monitor = monitor;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public void setStorageSize(Integer storageSize) {
        this.storageSize = storageSize;
    }

//    @Type(type="double")
    public double getPrice() {
//        return  this.price == null ? .0 : price;
        return price;
    }

//    @Type(type="double")
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptops laptops = (Laptops) o;

        if (monitor != laptops.monitor) return false;
        if (ram != laptops.ram) return false;
        if (Double.compare(laptops.price, price) != 0) return false;
        if (id != null ? !id.equals(laptops.id) : laptops.id != null) return false;
        if (manufacturer != null ? !manufacturer.equals(laptops.manufacturer) : laptops.manufacturer != null)
            return false;
        if (model != null ? !model.equals(laptops.model) : laptops.model != null) return false;
        if (cpu != null ? !cpu.equals(laptops.cpu) : laptops.cpu != null) return false;
        if (storageType != null ? !storageType.equals(laptops.storageType) : laptops.storageType != null) return false;
        if (storageSize != null ? !storageSize.equals(laptops.storageSize) : laptops.storageSize != null) return false;
        if (videoCard != null ? !videoCard.equals(laptops.videoCard) : laptops.videoCard != null) return false;
        return fileName != null ? fileName.equals(laptops.fileName) : laptops.fileName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + monitor;
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + ram;
        result = 31 * result + (storageType != null ? storageType.hashCode() : 0);
        result = 31 * result + (storageSize != null ? storageSize.hashCode() : 0);
        result = 31 * result + (videoCard != null ? videoCard.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
