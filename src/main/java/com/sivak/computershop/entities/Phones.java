package com.sivak.computershop.entities;

import javax.persistence.*;

@Entity
public class Phones implements Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String model;
    private int monitor;
    private String cpu;
    private int ram;
    private Integer storageSize;
    private boolean flashCard;
    private boolean dualSim;
    private String fileName;
    @Column(precision = 2)
    private double price;

    public Phones() {
    }

    public Phones(String manufacturer, String model, int monitor, String cpu,
                  int ram, Integer storageSize, boolean flashCard, boolean dualSim, double price) {
        this.dualSim = dualSim;
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

    public boolean isDualSim() {
        return dualSim;
    }

    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
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

        Phones phones = (Phones) o;

        if (monitor != phones.monitor) return false;
        if (ram != phones.ram) return false;
        if (flashCard != phones.flashCard) return false;
        if (dualSim != phones.dualSim) return false;
        if (Double.compare(phones.price, price) != 0) return false;
        if (id != null ? !id.equals(phones.id) : phones.id != null) return false;
        if (manufacturer != null ? !manufacturer.equals(phones.manufacturer) : phones.manufacturer != null)
            return false;
        if (model != null ? !model.equals(phones.model) : phones.model != null) return false;
        if (cpu != null ? !cpu.equals(phones.cpu) : phones.cpu != null) return false;
        if (storageSize != null ? !storageSize.equals(phones.storageSize) : phones.storageSize != null) return false;
        return fileName != null ? fileName.equals(phones.fileName) : phones.fileName == null;
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
        result = 31 * result + (storageSize != null ? storageSize.hashCode() : 0);
        result = 31 * result + (flashCard ? 1 : 0);
        result = 31 * result + (dualSim ? 1 : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
