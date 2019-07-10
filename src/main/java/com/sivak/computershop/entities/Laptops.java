package com.sivak.computershop.entities;

import javax.persistence.*;

@Entity
public class Laptops {
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
        this.manufacturer = manufacturer;
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
    public Double getPrice() {
//        return  this.price == null ? .0 : price;
        return price;
    }

//    @Type(type="double")
    public void setPrice(double price) {
        this.price = price;
    }
}
