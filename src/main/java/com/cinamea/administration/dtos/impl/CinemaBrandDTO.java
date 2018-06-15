/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.dtos.impl;

import com.cinamea.administration.controllers.validators.annotations.Required;
import com.cinamea.administration.dtos.DTO;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author micamicu
 */
public class CinemaBrandDTO implements DTO {
    
    private Long id;
    
    @Required
    private String brandName;
    
    private ZonedDateTime createdAt;
    
    private List<CinemaCountryDTO> cinemaCountryDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<CinemaCountryDTO> getCinemaCountryDTOs() {
        return cinemaCountryDTOs;
    }

    public void setCinemaCountryDTOs(List<CinemaCountryDTO> cinemaCountryDTOs) {
        this.cinemaCountryDTOs = cinemaCountryDTOs;
    }
}
