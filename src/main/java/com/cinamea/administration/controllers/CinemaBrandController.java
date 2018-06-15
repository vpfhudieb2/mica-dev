/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers;

import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.exceptions.NotFoundException;
import com.cinamea.administration.exceptions.ValidationException;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinamea.administration.utils.HATEOSUtil;
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
@RequestMapping("cinemaBrands")
public class CinemaBrandController {
    
    @Autowired
    private CinemaBrandManagementService cinemaBrandManagementService;
    
    @PostMapping(
            path = "/new",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createNew(@Valid @RequestBody CinemaBrandDTO cinemaBrandDTO, 
            BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            throw new ValidationException(bindingResult);
        
        cinemaBrandDTO = cinemaBrandManagementService.saveCinemaBrand(cinemaBrandDTO);
        
        return ResponseEntity
                .created(HATEOSUtil.getURILinkedToControllerMethod(this.getClass(), new Object[]{cinemaBrandDTO.getId()}, "getCinemaBrand", Long.class))
                .build();
    }
    
    @GetMapping(
            path = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<CinemaBrandDTO> getCinemaBrand(@PathVariable Long id) throws NotFoundException{
        
        return ResponseEntity.ok(cinemaBrandManagementService.getCinemaBrand(id));
    }
}
