/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services.impl;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.exceptions.NotFoundException;
import com.cinamea.administration.repositories.CinemaBrandRepository;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinamea.administration.utils.EntityToDTOUtils;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author micamicu
 */
@Service
public class CinemaBrandManagementServiceImpl implements CinemaBrandManagementService{

    @Autowired
    private CinemaBrandRepository cinemaBrandRepository;
    
    @Override
    public List<CinemaBrandDTO> getCinemaBrands() {
        List<CinemaBrandEntity> result = new ArrayList<>();
        
        cinemaBrandRepository
                .findAll()
                .forEach(cinemaBrandEntity -> result.add(cinemaBrandEntity));
        
        return EntityToDTOUtils.getCinemaBrandDTOFrom(result);
    }

    @Override
    public CinemaBrandDTO getCinemaBrand(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CinemaBrandDTO getCinemaBrand(Long id) throws NotFoundException{
        
        return EntityToDTOUtils.getCinemaBrandDTOFrom(
                cinemaBrandRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public CinemaBrandDTO saveCinemaBrand(CinemaBrandDTO cinemaBrandDTO) {

        CinemaBrandEntity cinemaBrandEntity = new CinemaBrandEntity();
        cinemaBrandEntity.setName(cinemaBrandDTO.getBrandName());
        cinemaBrandEntity.setCreatedAt(OffsetDateTime.now());
        
        cinemaBrandEntity = cinemaBrandRepository.save(cinemaBrandEntity);
        
        return EntityToDTOUtils.getCinemaBrandDTOFrom(cinemaBrandEntity);
    }

    @Override
    public void deleteCinemaBrand(Long brandId) {
        Optional<CinemaBrandEntity> optional = cinemaBrandRepository.findById(brandId);
        
        if(optional.isPresent())
            cinemaBrandRepository.delete(optional.get());
    }
}
