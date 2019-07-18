package com.sivak.computershop.entities;

import javax.persistence.*;

@Entity
public class Tablets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String os;
    private String manufacturer;
    private String model;
    private int monitor;
    private String cpu;
    private int ram;
    private boolean flashCard;
    private Integer storageSize;
    private String videoCard;
    private String fileName;
    @Column(precision = 2)
    private double price;


    public Tablets() {
    }

    public Tablets(String OSystem, String manufacturer, String model, int monitor, String cpu, int ram,
                   boolean flashCard, Integer storageSize, String videoCard, double price) {
        this.os = OSystem;
        this.manufacturer = manufacturer;
        this.model = model;
        this.monitor = monitor;
        this.cpu = cpu;
        this.ram = ram;
        this.flashCard = flashCard;
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

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public boolean isFlashCard() {
        return flashCard;
    }

    public void setFlashCard(boolean flashCard) {
        this.flashCard = flashCard;
    }

    public Integer getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(Integer storageSize) {
        this.storageSize = storageSize;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
