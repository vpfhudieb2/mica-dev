/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.unit.config;

import com.cinamea.administration.services.CinemaBrandManagementService;
import com.cinamea.administration.services.CinemaCountryManagementService;
import com.cinamea.administration.services.impl.CinemaBrandManagementServiceImpl;
import com.cinamea.administration.services.impl.CinemaCountryManagementServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author micamicu
 */
@TestConfiguration
public class ServicesConfig {
    
    @Lazy
    @Bean
    public CinemaBrandManagementService getCinemaBrandManagementService(){
        return new CinemaBrandManagementServiceImpl();
    }

    @Lazy
    @Bean
    public CinemaCountryManagementService getCinemaCountryManagementService(){
        return new CinemaCountryManagementServiceImpl();
    }
}
