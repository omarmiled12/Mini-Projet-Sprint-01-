package com.omar.tvs.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarque;
    
    private String nomMarque;
    private String paysOrigine;

    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Tv> tvs;

    // Optional: Add a custom setter if you still want to manually control it
    public void setIdMarque(Long id) {
        this.idMarque = id;
    }
}
