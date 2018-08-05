/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.integration.controllers;

import com.cinema.administration.integration.AbstractControllerApplicationContext;
import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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

        given(cinemaBrandManagementService.saveCinemaBrand(any(CinemaBrandDTO.class)))
                .willReturn(cinemaXBrandEntity);
        
        this.mockMvc
                .perform(
                            post("/cinemaBrands/new")
                           .contentType(MediaType.APPLICATION_JSON)
                           .content(objectMapper.writeValueAsBytes(cinemaXBrandDTO))
                           .characterEncoding("utf8")
                           .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));
    }
}
