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
@Table(name = "cinema_branch_show_rooms")
public class CinemaBranchShowRoomEntity extends AbstractEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;
    
    @Column(name = "total_capacity", nullable = false)
    private Integer totalCapacity;
    
    @Column(name = "rows_count", nullable = false)
    private Integer rownCount;
    
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

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getRownCount() {
        return rownCount;
    }

    public void setRownCount(Integer rownCount) {
        this.rownCount = rownCount;
    }

    public CinemaBranchEntity getCinemaBranchEntity() {
        return cinemaBranchEntity;
    }

    public void setCinemaBranchEntity(CinemaBranchEntity cinemaBranchEntity) {
        this.cinemaBranchEntity = cinemaBranchEntity;
    }
}
