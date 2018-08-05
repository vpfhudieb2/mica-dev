/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers.advices;

import com.cinamea.administration.dtos.impl.errors.ServiceErrors;
import com.cinamea.administration.exceptions.BaseException;
import com.cinamea.administration.exceptions.impl.ValidationException;
import com.cinamea.administration.utils.ResponseMappingUtil;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author micamicu
 */
@ControllerAdvice
public class ExceptionResponseMapper {
    
    @Autowired
    private MessageSource messageSource;
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServiceErrors> handleValidationExceptions(
            ValidationException validationException,
            Locale locale){
        
        return ResponseEntity
                .badRequest()
                .body(ResponseMappingUtil.createValidationErrorsFromBindingResult(validationException.getBindingResult(), messageSource, locale));
    }
    
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ServiceErrors> handleBaseException(
            BaseException baseException,
            Locale locale){
            
        return ResponseEntity
                .badRequest()
                .body(ResponseMappingUtil.createServiceErrorFromBaseException(baseException, locale, messageSource)); }
}
