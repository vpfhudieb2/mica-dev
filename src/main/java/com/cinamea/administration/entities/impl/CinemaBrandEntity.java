/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.entities.impl;

import com.cinamea.administration.entities.AbstractEntity;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author micamicu
 */
@Entity
@Table(name = "cinema_brands")
public class CinemaBrandEntity extends AbstractEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_brands_seq")
    @SequenceGenerator(name = "cinema_brands_seq", sequenceName = "cinema_brands_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "cinemaBrandEntity", cascade = CascadeType.ALL)
    private List<CinemaCountryEntity> cinemaCountryEntities;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaCountryEntity> getCinemaCountryEntities() {
        
        if(cinemaCountryEntities == null){
            cinemaCountryEntities = new ArrayList<>();
        }
        
        return cinemaCountryEntities;
    }

    public void setCinemaCountryEntities(List<CinemaCountryEntity> cinemaCountryEntities) {
        this.cinemaCountryEntities = cinemaCountryEntities;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
