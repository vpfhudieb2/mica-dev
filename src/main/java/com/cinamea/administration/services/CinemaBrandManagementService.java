/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.exceptions.impl.AlreadyExistsException;
import com.cinamea.administration.exceptions.impl.NotFoundException;
import java.util.List;

/**
 *
 * @author micamicu
 */
public interface CinemaBrandManagementService {
    
    CinemaBrandEntity saveCinemaBrand(CinemaBrandDTO cinemaBrandDTO) throws AlreadyExistsException;
    
    void deleteCinemaBrand(Long brandId) throws NotFoundException;
    
    List<CinemaBrandEntity> getCinemaBrands();
    
    CinemaBrandEntity getCinemaBrand(String name);

    CinemaBrandEntity getCinemaBrand(Long id) throws NotFoundException;
    
    void updateCinemaBrand(CinemaBrandDTO cinemaBrandDTO) throws NotFoundException;
}
