/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.entities.impl;

import com.cinamea.administration.entities.AbstractEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author micamicu
 */
@Entity
@Table(name = "cinema_countries")
public class CinemaCountryEntity extends AbstractEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_countries_seq")
    @SequenceGenerator(name = "cinema_countries_seq", sequenceName = "cinema_countries_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "country_code", nullable = false)
    private String countryCode;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_brand_id", nullable = false)
    private CinemaBrandEntity cinemaBrandEntity;

    @OneToMany(mappedBy = "cinemaCountryEntity", fetch = FetchType.LAZY)
    private List<CinemaBranchEntity> cinemaBranchEntities;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CinemaBrandEntity getCinemaBrandEntity() {
        return cinemaBrandEntity;
    }

    public void setCinemaBrandEntity(CinemaBrandEntity cinemaBrandEntity) {
        this.cinemaBrandEntity = cinemaBrandEntity;
    }

    public List<CinemaBranchEntity> getCinemaBranchEntities() {
        return cinemaBranchEntities;
    }

    public void setCinemaBranchEntities(List<CinemaBranchEntity> cinemaBranchEntities) {
        this.cinemaBranchEntities = cinemaBranchEntities;
    }
}
