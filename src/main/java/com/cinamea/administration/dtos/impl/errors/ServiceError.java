/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.dtos.impl.errors;

/**
 *
 * @author micamicu
 */
public class ServiceError {
    
    private ServiceErrorType errorType;
    
    private String fieldName;
    
    private String internationalizedErrorMessage;

    public ServiceError(ServiceErrorType errorType, String fieldName, String internationalizedErrorMessage) {
        this.errorType = errorType;
        this.fieldName = fieldName;
        this.internationalizedErrorMessage = internationalizedErrorMessage;
    }
    
    public ServiceErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ServiceErrorType errorType) {
        this.errorType = errorType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getInternationalizedErrorMessage() {
        return internationalizedErrorMessage;
    }

    public void setInternationalizedErrorMessage(String internationalizedErrorMessage) {
        this.internationalizedErrorMessage = internationalizedErrorMessage;
    }
}
