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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablets tablets = (Tablets) o;

        if (monitor != tablets.monitor) return false;
        if (ram != tablets.ram) return false;
        if (flashCard != tablets.flashCard) return false;
        if (Double.compare(tablets.price, price) != 0) return false;
        if (id != null ? !id.equals(tablets.id) : tablets.id != null) return false;
        if (os != null ? !os.equals(tablets.os) : tablets.os != null) return false;
        if (manufacturer != null ? !manufacturer.equals(tablets.manufacturer) : tablets.manufacturer != null)
            return false;
        if (model != null ? !model.equals(tablets.model) : tablets.model != null) return false;
        if (cpu != null ? !cpu.equals(tablets.cpu) : tablets.cpu != null) return false;
        if (storageSize != null ? !storageSize.equals(tablets.storageSize) : tablets.storageSize != null) return false;
        if (videoCard != null ? !videoCard.equals(tablets.videoCard) : tablets.videoCard != null) return false;
        return fileName != null ? fileName.equals(tablets.fileName) : tablets.fileName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + monitor;
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + ram;
        result = 31 * result + (flashCard ? 1 : 0);
        result = 31 * result + (storageSize != null ? storageSize.hashCode() : 0);
        result = 31 * result + (videoCard != null ? videoCard.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
