/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services.impl;

import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import com.cinamea.administration.repositories.CinemaCountryRepository;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinamea.administration.services.CinemaCountryManagementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author micamicu
 */
@Service
public class CinemaCountryManagementServiceImpl implements CinemaCountryManagementService{

    @Autowired
    private CinemaCountryRepository cinemaCountryRepository;
    
    @Autowired
    private CinemaBrandManagementService cinemaBrandManagementService;
    
    @Override
    public CinemaCountryEntity saveCinemaCountry(CinemaCountryDTO cinemaCountryDTO, Long cinemaBrandId) throws NotFoundException, AlreadyExistsException{
        
        if(getCinemaCountry(cinemaBrandId, cinemaCountryDTO.getCountryCode()) != null)
            throw new AlreadyExistsException("CinemaCountry", "[brandId, countryCode]", String.format("[%d, %s]", cinemaBrandId, cinemaCountryDTO.getCountryCode()));
        
        CinemaBrandEntity cinemaBrandEntity = cinemaBrandManagementService.getCinemaBrand(cinemaBrandId);
        CinemaCountryEntity cinemaCountryEntity = new CinemaCountryEntity();
        cinemaCountryEntity.setCountryCode(cinemaCountryDTO.getCountryCode());
        cinemaCountryEntity.setCinemaBrandEntity(cinemaBrandEntity);
        
        cinemaCountryEntity = cinemaCountryRepository.save(cinemaCountryEntity);
        
        return cinemaCountryEntity;
    }

    @Override
    public void deleteCinemaCountry(Long cinemaCountryId) throws NotFoundException{
        CinemaCountryEntity cinemaCountryEntity = getCinemaCountry(cinemaCountryId);
        cinemaCountryRepository.delete(cinemaCountryEntity);
    }

    @Override
    public List<CinemaCountryEntity> getCinemaCountriesForBrand(Long brandId) throws NotFoundException{
        return cinemaBrandManagementService.getCinemaBrand(brandId).getCinemaCountryEntities();
    }

    @Override
    public CinemaCountryEntity getCinemaCountry(Long cinemaCountryId) throws NotFoundException {
        return 
                cinemaCountryRepository
                        .findById(cinemaCountryId)
                        .orElseThrow( () ->
                                new NotFoundException("CinemaCountry", String.valueOf(cinemaCountryId))
                        );
    }

    @Override
    public void updateCinemaCountry(CinemaCountryDTO cinemaCountryDTO) throws NotFoundException {

        CinemaCountryEntity cinemaCountryEntity = getCinemaCountry(cinemaCountryDTO.getId());
        cinemaCountryEntity.setCountryCode(cinemaCountryDTO.getCountryCode());

        cinemaCountryRepository.save(cinemaCountryEntity);
    }    

    @Override
    public CinemaCountryEntity getCinemaCountry(Long cinemaBrandId, String countryCode) {
        return cinemaCountryRepository.getByCinemaBrandIdAndCountryCode(cinemaBrandId, countryCode);
    }
}
