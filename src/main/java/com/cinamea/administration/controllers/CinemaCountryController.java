/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers;

import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import com.cinamea.administration.exceptions.impl.ValidationException;
import com.cinamea.administration.services.CinemaCountryManagementService;
import com.cinamea.administration.utils.EntityToDTOUtils;
import com.cinamea.administration.utils.HATEOSUtil;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author micamicu
 */
@RestController
@RequestMapping("cinemaBrands/{cinemaBrand}/countries")
public class CinemaCountryController {
    
    @Autowired
    private CinemaCountryManagementService cinemaCountryManagementService;
    
    @PostMapping(
            path = "/new",
            consumes = "application/json")
    public ResponseEntity createNewCinemaCountry (
            @PathVariable Long cinemaBrand, 
            @Valid @RequestBody CinemaCountryDTO cinemaCountryDTO,
            BindingResult bindingResult) throws NotFoundException, AlreadyExistsException{
        
        if(bindingResult.hasErrors())
            throw new ValidationException(bindingResult);
        
        CinemaCountryEntity cinemaCountryEntity = cinemaCountryManagementService.saveCinemaCountry(cinemaCountryDTO, cinemaBrand);
        
        return ResponseEntity
                .created(HATEOSUtil.getURILinkedToControllerMethod(this.getClass(), new Object[]{cinemaBrand, cinemaCountryEntity.getId()}, "getCinemaCountry", Long.class)).build();
    }
    
    @GetMapping(
            path = "/{id}",
            produces = "application/json")
    public ResponseEntity<CinemaCountryDTO> getCinemaCountry(@PathVariable Long id) throws NotFoundException{
        
        CinemaCountryEntity countryEntity = cinemaCountryManagementService.getCinemaCountry(id);
        
        return ResponseEntity.ok(EntityToDTOUtils.getCinemaCountryDTOFrom(countryEntity));
    }
    
    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<List<CinemaCountryDTO>> getCinemaCountriesForBrand(@PathVariable Long cinemaBrand) throws NotFoundException{
        
        List<CinemaCountryEntity> cinemaCountryEntities = cinemaCountryManagementService.getCinemaCountriesForBrand(cinemaBrand);
        
        return ResponseEntity.ok(EntityToDTOUtils.getCinemaCountryDTOFrom(cinemaCountryEntities));
    }
}
