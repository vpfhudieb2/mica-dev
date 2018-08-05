/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.common.stubs;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author micamicu
 */
@TestConfiguration
public class StubsConfig {
        
    @Bean
    @Qualifier(CinemaBrandNames.MICA_CIMA)
    public CinemaBrandEntity getCinemaBrandEntityCimaMica(){
        
        CinemaBrandEntity cinemaBrandEntity = new CinemaBrandEntity();
        cinemaBrandEntity.setName(CinemaBrandNames.MICA_CIMA);
        cinemaBrandEntity.setId(2L);
        cinemaBrandEntity.setCreatedAt(Instant.now());

        return cinemaBrandEntity;
    }
    
    @Bean
    @Qualifier(CinemaBrandNames.CINEMA_X)
    public CinemaBrandEntity getCinemaBrandEntityCinemaX(){
        
        CinemaBrandEntity cinemaBrandEntity = new CinemaBrandEntity();
        cinemaBrandEntity.setName(CinemaBrandNames.CINEMA_X);
        cinemaBrandEntity.setId(1L);
        cinemaBrandEntity.setCreatedAt(Instant.now());

        return cinemaBrandEntity;
    }

    @Bean
    @Qualifier(CinemaBrandNames.CINEMA_HOUSE)
    public CinemaBrandEntity getCinemaBrandEntityCinemaHouse(){
        
        CinemaBrandEntity cinemaBrandEntity = new CinemaBrandEntity();
        cinemaBrandEntity.setName(CinemaBrandNames.CINEMA_HOUSE);
        cinemaBrandEntity.setId(3L);
        cinemaBrandEntity.setCreatedAt(Instant.now());
        
        return cinemaBrandEntity;
    }

    @Bean
    @Qualifier(CinemaBrandNames.CINEMA_HOUSE)
    public CinemaBrandDTO getCinemaBrandDTOCinemaHouse(){
        
        CinemaBrandDTO cinemaBrandDTO = new CinemaBrandDTO();
        cinemaBrandDTO.setBrandName(CinemaBrandNames.CINEMA_HOUSE);

        return cinemaBrandDTO;
    }

    @Bean
    @Qualifier(CinemaBrandNames.CINEMA_X)
    public CinemaBrandDTO getCinemaBrandDTOCinemaX(){
        
        CinemaBrandDTO cinemaBrandDTO = new CinemaBrandDTO();
        cinemaBrandDTO.setBrandName(CinemaBrandNames.CINEMA_X);

        return cinemaBrandDTO;
    }

    @Bean
    @Qualifier(CinemaBrandNames.MICA_CIMA)
    public CinemaBrandDTO getCinemaBrandDTOMicaCima(){
        
        CinemaBrandDTO cinemaBrandDTO = new CinemaBrandDTO();
        cinemaBrandDTO.setBrandName(CinemaBrandNames.MICA_CIMA);

        return cinemaBrandDTO;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.GERMANY)
    public CinemaCountryDTO getCinemaCountryDTOGermany(){
        
        CinemaCountryDTO cinemaCountryDTO = new CinemaCountryDTO();
        cinemaCountryDTO.setCountryCode(CinemaCountryCodes.GERMANY);
        
        return cinemaCountryDTO;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.GERMANY)
    public CinemaCountryEntity getCinemaCountryEntityGermany(){
        
        CinemaCountryEntity cinemaCountryEntity = new CinemaCountryEntity();
        cinemaCountryEntity.setCountryCode(CinemaCountryCodes.GERMANY);
        cinemaCountryEntity.setId(1L);
        
        return cinemaCountryEntity;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.FRANCE)
    public CinemaCountryDTO getCinemaCountryDTOFrance(){
        
        CinemaCountryDTO cinemaCountryDTO = new CinemaCountryDTO();
        cinemaCountryDTO.setCountryCode(CinemaCountryCodes.FRANCE);
        
        return cinemaCountryDTO;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.FRANCE)
    public CinemaCountryEntity getCinemaCountryEntityFrance(){
        
        CinemaCountryEntity cinemaCountryEntity = new CinemaCountryEntity();
        cinemaCountryEntity.setCountryCode(CinemaCountryCodes.FRANCE);
        cinemaCountryEntity.setId(2L);
        
        return cinemaCountryEntity;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.ENGLAND)
    public CinemaCountryDTO getCinemaCountryDTOEngland(){
        
        CinemaCountryDTO cinemaCountryDTO = new CinemaCountryDTO();
        cinemaCountryDTO.setCountryCode(CinemaCountryCodes.ENGLAND);
        
        return cinemaCountryDTO;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.ENGLAND)
    public CinemaCountryEntity getCinemaCountryEntityEngland(){
        
        CinemaCountryEntity cinemaCountryEntity = new CinemaCountryEntity();
        cinemaCountryEntity.setCountryCode(CinemaCountryCodes.ENGLAND);
        cinemaCountryEntity.setId(3L);
        
        return cinemaCountryEntity;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.JORDAN)
    public CinemaCountryDTO getCinemaCountryDTOJordan(){
        
        CinemaCountryDTO cinemaCountryDTO = new CinemaCountryDTO();
        cinemaCountryDTO.setCountryCode(CinemaCountryCodes.JORDAN);
        
        return cinemaCountryDTO;
    }

    @Bean
    @Qualifier(CinemaCountryCodes.JORDAN)
    public CinemaCountryEntity getCinemaCountryEntityJordan(){
        
        CinemaCountryEntity cinemaCountryEntity = new CinemaCountryEntity();
        cinemaCountryEntity.setCountryCode(CinemaCountryCodes.JORDAN);
        cinemaCountryEntity.setId(4L);
        
        return cinemaCountryEntity;
    }
}