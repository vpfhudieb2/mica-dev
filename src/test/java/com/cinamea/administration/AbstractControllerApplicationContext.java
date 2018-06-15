/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration;

import com.cinamea.administration.services.CinemaBrandManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author micamicu
 */
@SpringBootTest
public class AbstractControllerApplicationContext {
    
    @Autowired
    protected ObjectMapper objectMapper;
    
    @Autowired
    protected MockMvc mockMvc;
    
    @MockBean
    protected CinemaBrandManagementService cinemaBrandManagementService;
    
}
