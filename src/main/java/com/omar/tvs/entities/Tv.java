package com.omar.tvs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Tv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTv;
    private String screenSize;
    private Double priceTv;
    private String resolution;
    private String displayTechnology;
    private String manufacturer; // Added manufacturer instead of model
    private Date manufactureDate;

    public Tv() {
        super();
    }

    public Tv(String screenSize, Double priceTv, String resolution, 
             String displayTechnology, String manufacturer, Date manufactureDate) {
        super();
        this.screenSize = screenSize;
        this.priceTv = priceTv;
        this.resolution = resolution;
        this.displayTechnology = displayTechnology;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
    }

    // Getters and Setters
    public Long getIdTv() {
        return idTv;
    }

    public void setIdTv(Long idTv) {
        this.idTv = idTv;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public Double getPriceTv() {
        return priceTv;
    }

    public void setPriceTv(Double priceTv) {
        this.priceTv = priceTv;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDisplayTechnology() {
        return displayTechnology;
    }

    public void setDisplayTechnology(String displayTechnology) {
        this.displayTechnology = displayTechnology;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Tv [idTv=" + idTv + ", screenSize=" + screenSize 
               + ", priceTv=" + priceTv + ", resolution=" + resolution
               + ", displayTechnology=" + displayTechnology + ", manufacturer=" + manufacturer
               + ", manufactureDate=" + manufactureDate + "]";
    }
}