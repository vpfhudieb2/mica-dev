/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.utils;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.dtos.impl.CinemaCountryDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author micamicu
 */
public class EntityToDTOUtils {

    public static CinemaBrandDTO getCinemaBrandDTOFrom(CinemaBrandEntity cinemaBrandEntity){
        
        if(cinemaBrandEntity == null)
            return null;
        
        CinemaBrandDTO cinemaBrandDTO = new CinemaBrandDTO();
        cinemaBrandDTO.setId(cinemaBrandEntity.getId());
        cinemaBrandDTO.setBrandName(cinemaBrandEntity.getName());
        cinemaBrandDTO.setCinemaCountryDTOs(getCinemaCountryDTOFrom(cinemaBrandEntity.getCinemaCountryEntities()));
        
        return cinemaBrandDTO;
    }
    
    public static List<CinemaBrandDTO> getCinemaBrandDTOFrom(List<CinemaBrandEntity> cinemaBrandEntities){
        
        if(cinemaBrandEntities == null)
            return null;
        
        return cinemaBrandEntities
                .stream()
                .map(cinemaCountryEntity -> getCinemaBrandDTOFrom(cinemaCountryEntity))
                .collect(Collectors.toList());
    }

    public static CinemaCountryDTO getCinemaCountryDTOFrom(CinemaCountryEntity cinemaCountryEntity){
        
        if(cinemaCountryEntity == null)
            return null;
        
        CinemaCountryDTO cinemaCountryDTO = new CinemaCountryDTO();
        cinemaCountryDTO.setCountryCode(cinemaCountryEntity.getCountryCode());
        cinemaCountryDTO.setId(cinemaCountryEntity.getId());
        
        return cinemaCountryDTO;
    }
    
    public static List<CinemaCountryDTO> getCinemaCountryDTOFrom(List<CinemaCountryEntity> cinemaCountryEntities){
        
        if(cinemaCountryEntities == null)
            return null;
        
        return cinemaCountryEntities
                .stream()
                .map(cinemaCountryEntity -> getCinemaCountryDTOFrom(cinemaCountryEntity))
                .collect(Collectors.toList());
    }
}
