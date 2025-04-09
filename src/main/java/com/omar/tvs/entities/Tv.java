package com.omar.tvs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Tv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTv;
    private String screenSize;
    private Double priceTv;
    private String resolution;
    private String nomTv; // changed from displayTechnology to nomTv
    private Date manufactureDate;
    @ManyToOne
    private Marque marque;

    public Tv() {
        super();
    }

    public Tv(String screenSize, Double priceTv, String resolution, 
             String nomTv, Date manufactureDate) {
        super();
        this.screenSize = screenSize;
        this.priceTv = priceTv;
        this.resolution = resolution;
        this.nomTv = nomTv;
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

    public String getNomTv() {
        return nomTv;
    }

    public void setNomTv(String nomTv) {
        this.nomTv = nomTv;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Marque getMarque() {
        return marque;
    }
    
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Tv [idTv=" + idTv + ", screenSize=" + screenSize 
               + ", priceTv=" + priceTv + ", resolution=" + resolution
               + ", nomTv=" + nomTv 
               + ", manufactureDate=" + manufactureDate + "]";
    }
}
