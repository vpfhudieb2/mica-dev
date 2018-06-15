/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers;

import com.cinamea.administration.AbstractControllerApplicationContext;
import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

import static org.mockito.BDDMockito.*;

/**
 *
 * @author micamicu
 */
@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = CinemaBrandController.class)
@AutoConfigureMockMvc
public class CinemaBrandControllerTest extends AbstractControllerApplicationContext{
    
    @Test
    public void testCreateNew() throws Exception{
        CinemaBrandDTO cinemaBrandDTO = new CinemaBrandDTO();
        cinemaBrandDTO.setBrandName("Mimi");
        
        CinemaBrandDTO savedCinemaBrandDTO = new CinemaBrandDTO();
        savedCinemaBrandDTO.setBrandName("Mimi");
        savedCinemaBrandDTO.setId(12L);
        
        given(cinemaBrandManagementService.saveCinemaBrand(any(CinemaBrandDTO.class)))
                .willReturn(savedCinemaBrandDTO);
        
        this.mockMvc
                .perform(
                            post("/cinemaBrands/new")
                           .contentType(MediaType.APPLICATION_JSON)
                           .content(objectMapper.writeValueAsBytes(cinemaBrandDTO))
                           .characterEncoding("utf8")
                           .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));
    }
}
