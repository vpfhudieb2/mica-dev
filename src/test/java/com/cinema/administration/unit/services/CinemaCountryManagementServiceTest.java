/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.unit.services;

import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import com.cinamea.administration.repositories.CinemaCountryRepository;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinamea.administration.services.CinemaCountryManagementService;
import com.cinema.administration.common.stubs.CinemaBrandNames;
import com.cinema.administration.common.stubs.CinemaCountryCodes;
import com.cinema.administration.unit.AbstractUnitTest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author micamicu
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaCountryManagementServiceTest extends AbstractUnitTest{
    
    @MockBean
    private CinemaBrandManagementService cinemaBrandManagementService;
    
    @MockBean
    private CinemaCountryRepository cinemaCountryRepository;
    
    @Autowired
    private CinemaCountryManagementService cinemaCountryManagementService;
    
    @Autowired
    @Qualifier(CinemaCountryCodes.GERMANY)
    private CinemaCountryDTO cinemaCountryDTOGermany;
    
    @Autowired
    @Qualifier(CinemaCountryCodes.GERMANY)
    private CinemaCountryEntity cinemaCountryEntityGermany;

    @Autowired
    @Qualifier(CinemaCountryCodes.ENGLAND)
    private CinemaCountryDTO cinemaCountryDTOEngland;
    
    @Autowired
    @Qualifier(CinemaCountryCodes.ENGLAND)
    private CinemaCountryEntity cinemaCountryEntityEngland;

    @Autowired
    @Qualifier(CinemaBrandNames.CINEMA_X)
    private CinemaBrandEntity cinemaBrandEntityCinemaX;
    
    @Test
    public void testSaveCinemaCountrySuccessfully() throws AlreadyExistsException, NotFoundException{
        
        given(cinemaCountryRepository.getByCinemaBrandIdAndCountryCode(cinemaBrandEntityCinemaX.getId(), cinemaCountryDTOGermany.getCountryCode())).willReturn(null);
        given(cinemaBrandManagementService.getCinemaBrand(cinemaBrandEntityCinemaX.getId())).willReturn(cinemaBrandEntityCinemaX);
        given(cinemaCountryRepository.save(any())).willReturn(cinemaCountryEntityGermany);
        
        CinemaCountryEntity savedCinemaCountryEntity = cinemaCountryManagementService.saveCinemaCountry(cinemaCountryDTOGermany, cinemaBrandEntityCinemaX.getId());
        
        assertThat(savedCinemaCountryEntity, equalTo(cinemaCountryEntityGermany));
    }

    @Test(expected = AlreadyExistsException.class)
    public void testSaveCinemaCountryAlreadyExists() throws AlreadyExistsException, NotFoundException{
        
        given(cinemaCountryRepository.getByCinemaBrandIdAndCountryCode(cinemaBrandEntityCinemaX.getId(), cinemaCountryDTOGermany.getCountryCode())).willReturn(cinemaCountryEntityGermany);
        given(cinemaBrandManagementService.getCinemaBrand(cinemaBrandEntityCinemaX.getId())).willReturn(cinemaBrandEntityCinemaX);
        given(cinemaCountryRepository.save(any())).willReturn(cinemaCountryEntityGermany);
        
        cinemaCountryManagementService.saveCinemaCountry(cinemaCountryDTOGermany, cinemaBrandEntityCinemaX.getId());
    }

    @Test(expected = NotFoundException.class)
    public void testSaveCinemaCountryBrandNotFound() throws AlreadyExistsException, NotFoundException{
        
        given(cinemaCountryRepository.getByCinemaBrandIdAndCountryCode(cinemaBrandEntityCinemaX.getId(), cinemaCountryDTOGermany.getCountryCode())).willReturn(null);
        given(cinemaBrandManagementService.getCinemaBrand(cinemaBrandEntityCinemaX.getId())).willThrow(NotFoundException.class);
        given(cinemaCountryRepository.save(any())).willReturn(cinemaCountryEntityGermany);
        
        cinemaCountryManagementService.saveCinemaCountry(cinemaCountryDTOGermany, cinemaBrandEntityCinemaX.getId());
    }
    
    @Test
    public void testDeleteCinemaCountrySuccessfully() throws NotFoundException{
        given(cinemaCountryRepository.findById(cinemaCountryEntityGermany.getId())).willReturn(Optional.of(cinemaCountryEntityGermany));
        
        cinemaCountryManagementService.deleteCinemaCountry(cinemaCountryEntityGermany.getId());
        
        verify(cinemaCountryRepository).findById(cinemaCountryEntityGermany.getId());
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteCinemaCountryThrowsNotFound() throws NotFoundException{
        given(cinemaCountryManagementService.getCinemaCountry(cinemaCountryEntityGermany.getId())).willThrow(NotFoundException.class);
        
        cinemaCountryManagementService.deleteCinemaCountry(cinemaCountryEntityGermany.getId());
    }    
    
    @Test
    public void testGetCinemaCountriesForBrandSuccessfully() throws NotFoundException{
        cinemaBrandEntityCinemaX.setCinemaCountryEntities(
                Stream.of(cinemaCountryEntityGermany, cinemaCountryEntityEngland)
                .collect(Collectors.toList()));
        
        given(cinemaBrandManagementService.getCinemaBrand(cinemaBrandEntityCinemaX.getId()))
                .willReturn(cinemaBrandEntityCinemaX);
        
        List<CinemaCountryEntity> cinemaCountryEntities = cinemaCountryManagementService.getCinemaCountriesForBrand(cinemaBrandEntityCinemaX.getId());
        
        assertThat(cinemaCountryEntities, hasSize(2));
        assertThat(cinemaCountryEntities, contains(cinemaCountryEntityGermany, cinemaCountryEntityEngland));
    }

    @Test(expected = NotFoundException.class)
    public void testGetCinemaCountriesForBrandNotFound() throws NotFoundException{
        given(cinemaBrandManagementService.getCinemaBrand(cinemaBrandEntityCinemaX.getId()))
                .willThrow(NotFoundException.class);
        
        cinemaCountryManagementService.getCinemaCountriesForBrand(cinemaBrandEntityCinemaX.getId());
    }

    @Test
    public void testGetCinemaCountrySuccessfully() throws NotFoundException{
        given(cinemaCountryRepository.findById(cinemaCountryEntityGermany.getId()))
                .willReturn(Optional.of(cinemaCountryEntityGermany));
        
        CinemaCountryEntity cinemaCountryEntity = cinemaCountryManagementService.getCinemaCountry(cinemaCountryEntityGermany.getId());
        
        assertThat(cinemaCountryEntity, equalTo(cinemaCountryEntityGermany));
    }

    @Test(expected = NotFoundException.class)
    public void testGetCinemaCountryNotFound() throws NotFoundException{
        given(cinemaCountryRepository.findById(cinemaCountryEntityGermany.getId()))
                .willReturn(Optional.empty());
        
        cinemaCountryManagementService.getCinemaCountry(cinemaCountryEntityGermany.getId());
    }

    @Test
    public void testUpdateCinemaCountrySuccessfully() throws NotFoundException{
        cinemaCountryDTOGermany.setCountryCode(cinemaCountryDTOEngland.getCountryCode());
        cinemaCountryDTOGermany.setId(cinemaCountryEntityGermany.getId());

        given(cinemaCountryRepository.findById(cinemaCountryDTOGermany.getId()))
                .willReturn(Optional.of(cinemaCountryEntityGermany));
        
        cinemaCountryManagementService.updateCinemaCountry(cinemaCountryDTOGermany);
        
        verify(cinemaCountryRepository).findById(cinemaCountryDTOGermany.getId());        
        verify(cinemaCountryRepository).save(any());
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateCinemaCountryNotFound() throws NotFoundException{
        given(cinemaCountryRepository.findById(cinemaCountryDTOGermany.getId()))
                .willReturn(Optional.empty());
        
        cinemaCountryManagementService.updateCinemaCountry(cinemaCountryDTOGermany);
    }
    
    @Test
    public void testGetCinemaCountryByBrandAndCountryCodeSuccessfuly(){
        
        given(cinemaCountryRepository.getByCinemaBrandIdAndCountryCode(cinemaBrandEntityCinemaX.getId(), cinemaCountryDTOGermany.getCountryCode())).willReturn(cinemaCountryEntityGermany);
        
        CinemaCountryEntity result = cinemaCountryManagementService.getCinemaCountry(cinemaBrandEntityCinemaX.getId(), cinemaCountryDTOGermany.getCountryCode());
        
        assertThat(result, equalTo(cinemaCountryEntityGermany));
    }
}
