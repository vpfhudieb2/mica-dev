/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.entities.impl;

import com.cinamea.administration.entities.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author micamicu
 */
@Entity
@Table(name = "reservation_points")
public class ReservationPointEntity extends AbstractEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;    
    
    @ManyToOne
    @JoinColumn(name = "cinema_branch_id", nullable = false)    
    private CinemaBranchEntity cinemaBranchEntity;

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

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public CinemaBranchEntity getCinemaBranchEntity() {
        return cinemaBranchEntity;
    }

    public void setCinemaBranchEntity(CinemaBranchEntity cinemaBranchEntity) {
        this.cinemaBranchEntity = cinemaBranchEntity;
    }
}
