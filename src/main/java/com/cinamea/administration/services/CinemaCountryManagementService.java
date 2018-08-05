/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services;

import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import java.util.List;

/**
 *
 * @author micamicu
 */
public interface CinemaCountryManagementService {
    
    CinemaCountryEntity saveCinemaCountry(CinemaCountryDTO cinemaCountryDTO, Long cinemaBrandId) throws NotFoundException, AlreadyExistsException;
    
    void deleteCinemaCountry(Long cinemaCountryId) throws NotFoundException;
    
    List<CinemaCountryEntity> getCinemaCountriesForBrand(Long brandId) throws NotFoundException;
    
    CinemaCountryEntity getCinemaCountry(Long cinemaBrandId, String countryCode);
    
    CinemaCountryEntity getCinemaCountry(Long cinemaCountryId) throws NotFoundException;
    
    void updateCinemaCountry(CinemaCountryDTO cinemaCountryDTO) throws NotFoundException;
}
