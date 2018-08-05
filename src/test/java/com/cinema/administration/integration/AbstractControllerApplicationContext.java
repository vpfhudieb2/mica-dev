/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.integration;

import com.cinamea.administration.AdministrationApplication;
import com.cinamea.administration.dtos.impl.CinemaBrandDTO;
import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinema.administration.common.stubs.CinemaBrandNames;
import com.cinema.administration.common.stubs.StubsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author micamicu
 */
@SpringBootTest(classes = {AdministrationApplication.class, StubsConfig.class})
//@ActiveProfiles("test")
public abstract class AbstractControllerApplicationContext {
    
    @Autowired
    protected ObjectMapper objectMapper;
    
    @Autowired
    protected MockMvc mockMvc;
    
    @Autowired
    @Qualifier(CinemaBrandNames.CINEMA_X)
    protected CinemaBrandEntity cinemaXBrandEntity;
    
    @Autowired
    @Qualifier(CinemaBrandNames.CINEMA_X)
    protected CinemaBrandDTO cinemaXBrandDTO;

    @MockBean
    protected CinemaBrandManagementService cinemaBrandManagementService;
    
}
