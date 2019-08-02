package com.sivak.computershop.entities;

import javax.persistence.*;

@Entity
public class Tablets implements Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String os;
    private String manufacturer;
    private String model;
    private int monitor;
    private String cpu;
    private int ram;
    private Integer storageSize;
    private boolean flashCard;
    private String fileName;
    @Column(precision = 2)
    private double price;

    public Tablets() {
    }

    public Tablets(String OSystem, String manufacturer, String model, int monitor,
                   String cpu, int ram,boolean flashCard, Integer storageSize, double price) {
        this.os = OSystem;
        this.manufacturer = manufacturer.toUpperCase();
        this.model = model;
        this.monitor = monitor;
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
        this.flashCard = flashCard;
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
        this.manufacturer = manufacturer.toUpperCase();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablets tablets = (Tablets) o;

        if (monitor != tablets.monitor) return false;
        if (ram != tablets.ram) return false;
        if (flashCard != tablets.flashCard) return false;
        if (Double.compare(tablets.price, price) != 0) return false;
        if (!id.equals(tablets.id)) return false;
        if (!os.equals(tablets.os)) return false;
        if (!manufacturer.equals(tablets.manufacturer)) return false;
        if (!model.equals(tablets.model)) return false;
        if (!cpu.equals(tablets.cpu)) return false;
        if (!storageSize.equals(tablets.storageSize)) return false;
        return fileName.equals(tablets.fileName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + os.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + monitor;
        result = 31 * result + cpu.hashCode();
        result = 31 * result + ram;
        result = 31 * result + (flashCard ? 1 : 0);
        result = 31 * result + storageSize.hashCode();
        result = 31 * result + fileName.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
