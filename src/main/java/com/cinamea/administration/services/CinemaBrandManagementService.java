/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.services;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.exceptions.NotFoundException;
import java.util.List;

/**
 *
 * @author micamicu
 */
public interface CinemaBrandManagementService {
    
    CinemaBrandDTO saveCinemaBrand(CinemaBrandDTO cinemaBrandDTO);
    
    void deleteCinemaBrand(Long brandId);
    
    List<CinemaBrandDTO> getCinemaBrands();
    
    CinemaBrandDTO getCinemaBrand(String name);

    CinemaBrandDTO getCinemaBrand(Long id) throws NotFoundException;        
}
