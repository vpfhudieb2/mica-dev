/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.utils;

import com.cinamea.administration.dtos.impl.errors.ServiceError;
import com.cinamea.administration.dtos.impl.errors.ServiceErrorType;
import com.cinamea.administration.dtos.impl.errors.ServiceErrors;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
            ServiceError serviceError = new ServiceError();
            serviceError.setErrorType(ServiceErrorType.VALIDATION);
            serviceError.setFieldName(fieldError.getField());
            serviceError.setInternationalizedErrorMessage(messageSource.getMessage(fieldError.getCode(), null, locale));
            
            serviceErrorsList.add(serviceError);
        });
        
        ServiceErrors errors = new ServiceErrors();
        errors.setErrors(serviceErrorsList);

        return errors;
    }
}
