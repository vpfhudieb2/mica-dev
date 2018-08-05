/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.unit.services;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import com.cinamea.administration.repositories.CinemaBrandRepository;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinema.administration.common.stubs.CinemaBrandNames;
import com.cinema.administration.unit.AbstractUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author micamicu
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaBrandManagementServiceTest extends AbstractUnitTest{
    @MockBean
    private CinemaBrandRepository cinemaBrandRepository;
    
    @Autowired
    private CinemaBrandManagementService cinemaBrandManagementService;
    
    @Autowired
    @Qualifier(CinemaBrandNames.CINEMA_X)
    private CinemaBrandEntity cinemaXBrandEntity;
    
    @Autowired
    @Qualifier(CinemaBrandNames.CINEMA_X)
    private CinemaBrandDTO cinemaXBrandDTO;
    
    @Autowired
    @Qualifier(CinemaBrandNames.MICA_CIMA)
    private CinemaBrandEntity micaCimaBrandEntity;

    @Test
    public void testSaveCinemaBrandSuccessfully() throws AlreadyExistsException{
        
        given(cinemaBrandRepository.getByNameIgnoreCase(cinemaXBrandDTO.getBrandName())).willReturn(null);
        given(cinemaBrandRepository.save(any())).willReturn(cinemaXBrandEntity);
        
        CinemaBrandEntity savedCinemaBrandEntity = cinemaBrandManagementService.saveCinemaBrand(cinemaXBrandDTO);
        assertThat(savedCinemaBrandEntity.getId(), is(equalTo(1L)));
    }
    
    @Test(expected = AlreadyExistsException.class)
    public void testSaveAlreadyExistsCinemaBrand() throws AlreadyExistsException{

        given(cinemaBrandRepository.getByNameIgnoreCase(cinemaXBrandDTO.getBrandName())).willReturn(cinemaXBrandEntity);

        cinemaBrandManagementService.saveCinemaBrand(cinemaXBrandDTO);
    }
    
    @Test
    public void testDeleteCinemaBrandSuccessfully() throws NotFoundException{
        given(cinemaBrandRepository.findById(cinemaXBrandEntity.getId())).willReturn(Optional.of(cinemaXBrandEntity));
        
        cinemaBrandManagementService.deleteCinemaBrand(cinemaXBrandEntity.getId());
        
        verify(cinemaBrandRepository).delete(cinemaXBrandEntity);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFoundCinemaBrand() throws NotFoundException{
        given(cinemaBrandRepository.findById(cinemaXBrandDTO.getId())).willReturn(Optional.empty());
        
        cinemaBrandManagementService.deleteCinemaBrand(cinemaXBrandDTO.getId());
    }
    
    @Test
    public void testGetCinemaBrandsSuccessfully(){
        Set<CinemaBrandEntity> brandEntities = Stream.of(cinemaXBrandEntity, micaCimaBrandEntity).collect(Collectors.toSet());
        
        given(cinemaBrandRepository.findAll()).willReturn(brandEntities);
        
        List<CinemaBrandEntity> cinemaBrandEntities = cinemaBrandManagementService.getCinemaBrands();
        
        assertThat(cinemaBrandEntities, hasSize(2));        
        assertThat(cinemaBrandEntities, contains(cinemaXBrandEntity, micaCimaBrandEntity));
        
    }
    
    @Test
    public void testGetCinemaBrandByNameSuccessfully(){
        
        given(cinemaBrandRepository.getByNameIgnoreCase(cinemaXBrandDTO.getBrandName())).willReturn(cinemaXBrandEntity);
        
        CinemaBrandEntity result = cinemaBrandManagementService.getCinemaBrand(cinemaXBrandDTO.getBrandName());
        
        assertThat(result, equalTo(cinemaXBrandEntity));
    }
    
    @Test
    public void testGetCinemaBrandByIdSuccessfully() throws NotFoundException{
        
        given(cinemaBrandRepository.findById(cinemaXBrandDTO.getId())).willReturn(Optional.of(cinemaXBrandEntity));
        
        CinemaBrandEntity result = cinemaBrandManagementService.getCinemaBrand(cinemaXBrandDTO.getId());
        
        assertThat(result, equalTo(result));
    }
    
    @Test(expected = NotFoundException.class)
    public void testGetNotFoundCinemaBrandById() throws NotFoundException{
                
        given(cinemaBrandRepository.findById(cinemaXBrandDTO.getId())).willReturn(Optional.empty());
        
        cinemaBrandManagementService.getCinemaBrand(cinemaXBrandDTO.getId());
    }
    
    @Test
    public void testUpdateCinemaBrandSuccessfully() throws NotFoundException{        
        
        String newBrandName = "CinemaX2";
        cinemaXBrandDTO.setBrandName(newBrandName);
        
        given(cinemaBrandRepository.findById(cinemaXBrandDTO.getId()))
                .willReturn(Optional.of(cinemaXBrandEntity));
        
        given(cinemaBrandRepository.save(any())).willReturn(cinemaXBrandEntity);
        
        cinemaBrandManagementService.updateCinemaBrand(cinemaXBrandDTO);
        
        verify(cinemaBrandRepository).findById(cinemaXBrandDTO.getId());
        verify(cinemaBrandRepository).save(any());
        
        assertThat(cinemaXBrandEntity.getName(), equalTo(newBrandName));
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateNotFoundCinemaBrand() throws NotFoundException{        

        String newBrandName = "CinemaX3";
        cinemaXBrandDTO.setBrandName(newBrandName);
        
        given(cinemaBrandRepository.findById(any()))
                .willReturn(Optional.empty());
        given(cinemaBrandRepository.save(any())).willReturn(cinemaXBrandEntity);
        
        cinemaBrandManagementService.updateCinemaBrand(cinemaXBrandDTO);
    }
}
