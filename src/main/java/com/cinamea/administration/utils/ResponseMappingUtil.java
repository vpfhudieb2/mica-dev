/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.utils;

import com.cinamea.administration.dtos.impl.errors.ServiceError;
import com.cinamea.administration.dtos.impl.errors.ServiceErrorType;
import com.cinamea.administration.dtos.impl.errors.ServiceErrors;
import com.cinamea.administration.exceptions.BaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

/**
 *
 * @author micamicu
 */
public class ResponseMappingUtil {

    public static ServiceErrors createValidationErrorsFromBindingResult(BindingResult bindingResult, MessageSource messageSource, Locale locale){
        List<ServiceError> serviceErrorsList = new ArrayList<>();
        
        bindingResult.getFieldErrors().stream().forEach(fieldError -> {
            ServiceError serviceError = new ServiceError(
                    ServiceErrorType.VALIDATION,
                    fieldError.getField(),
                    messageSource.getMessage(fieldError.getCode(), null, locale) );

            
            serviceErrorsList.add(serviceError);
        });
        
        ServiceErrors errors = new ServiceErrors();
        errors.setErrors(serviceErrorsList);

        return errors;
    }
    
    public static ServiceErrors createServiceErrorFromBaseException(BaseException baseException, Locale locale, MessageSource messageSource){
        
        ServiceErrors serviceErrors = new ServiceErrors();
        serviceErrors.setErrors(Arrays.asList(new ServiceError(
                baseException.getServiceErrorType(), 
                null, 
                messageSource.getMessage(baseException.getMessageCode(), baseException.getMessageParams(), locale))));
        
        return serviceErrors;
    }
}
