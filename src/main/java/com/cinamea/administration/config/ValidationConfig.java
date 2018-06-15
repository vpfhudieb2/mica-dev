/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.config;

import com.cinamea.administration.controllers.validators.AbstractValidator;
import com.cinamea.administration.controllers.validators.AnnotationValidator;
import com.cinamea.administration.controllers.validators.impl.RequiredValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author micamicu
 */
@Configuration
public class ValidationConfig {
    
    @Bean
    public AnnotationValidator annotationValidator(){
        return new AnnotationValidator();
    }
    
    @Bean(name = "requiredValidator")
    public AbstractValidator requiredValidator(){
        return new RequiredValidator();
    }
}