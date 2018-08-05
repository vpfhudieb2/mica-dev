/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services.impl;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import com.cinamea.administration.repositories.CinemaBrandRepository;
import com.cinamea.administration.services.CinemaBrandManagementService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
    public List<CinemaBrandEntity> getCinemaBrands() {
        List<CinemaBrandEntity> result = new ArrayList<>();
        
        cinemaBrandRepository
                .findAll()
                .forEach(cinemaBrandEntity -> result.add(cinemaBrandEntity));
        
        return result;
    }

    @Override
    public CinemaBrandEntity getCinemaBrand(String name) {
        return cinemaBrandRepository.getByNameIgnoreCase(name);
    }

    @Override
    public CinemaBrandEntity getCinemaBrand(Long id) throws NotFoundException{
        
        return cinemaBrandRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("CinemaBrand", id+""));
    }

    @Override
    public CinemaBrandEntity saveCinemaBrand(CinemaBrandDTO cinemaBrandDTO) throws AlreadyExistsException{

        if(getCinemaBrand(cinemaBrandDTO.getBrandName()) != null)
            throw new AlreadyExistsException("CinemaBrand", "name", cinemaBrandDTO.getBrandName());
        
        CinemaBrandEntity cinemaBrandEntity = new CinemaBrandEntity();
        cinemaBrandEntity.setName(cinemaBrandDTO.getBrandName());
        cinemaBrandEntity.setCreatedAt(Instant.now());
        
        cinemaBrandEntity = cinemaBrandRepository.save(cinemaBrandEntity);
        
        //return EntityToDTOUtils.getCinemaBrandDTOFrom(cinemaBrandEntity);
        return cinemaBrandEntity;
    }

    @Override
    public void updateCinemaBrand(CinemaBrandDTO cinemaBrandDTO) throws NotFoundException{

        CinemaBrandEntity cinemaBrandEntity = cinemaBrandRepository.
                findById(cinemaBrandDTO.getId()).orElseThrow( () -> new NotFoundException("CinemaBrand", cinemaBrandDTO.getId()+""));

        cinemaBrandEntity.setName(cinemaBrandDTO.getBrandName());

        cinemaBrandRepository.save(cinemaBrandEntity);
    }

    @Override
    public void deleteCinemaBrand(Long brandId) throws NotFoundException{
        CinemaBrandEntity cinemaBrandEntity = getCinemaBrand(brandId);
        cinemaBrandRepository.delete(cinemaBrandEntity);
    }
}
