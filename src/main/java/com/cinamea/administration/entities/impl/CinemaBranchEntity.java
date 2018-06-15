/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.entities.impl;

import com.cinamea.administration.entities.AbstractEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "cinema_branches")
public class CinemaBranchEntity extends AbstractEntity{
    
    @Id
    private Long id;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    
    @Column(name = "street", nullable = false)
    private String street;
    
    @Column(name = "address")
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "cinema_country_id", nullable = false)
    private CinemaCountryEntity cinemaCountryEntity;
    
    @OneToMany(mappedBy = "cinemaBranchEntity")
    private List<CinemaBranchShowRoomEntity> cinemaBranchShowRoomEntities;

    @OneToMany(mappedBy = "cinemaBranchEntity")
    private List<ReservationPointEntity> reservationPointEntities;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CinemaCountryEntity getCinemaCountryEntity() {
        return cinemaCountryEntity;
    }

    public void setCinemaCountryEntity(CinemaCountryEntity cinemaCountryEntity) {
        this.cinemaCountryEntity = cinemaCountryEntity;
    }

    public List<CinemaBranchShowRoomEntity> getCinemaBranchShowRoomEntities() {
        return cinemaBranchShowRoomEntities;
    }

    public void setCinemaBranchShowRoomEntities(List<CinemaBranchShowRoomEntity> cinemaBranchShowRoomEntities) {
        this.cinemaBranchShowRoomEntities = cinemaBranchShowRoomEntities;
    }

    public List<ReservationPointEntity> getReservationPointEntities() {
        return reservationPointEntities;
    }

    public void setReservationPointEntities(List<ReservationPointEntity> reservationPointEntities) {
        this.reservationPointEntities = reservationPointEntities;
    }
}
