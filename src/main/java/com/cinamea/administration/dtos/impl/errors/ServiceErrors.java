/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.dtos.impl.errors;

import java.util.List;

/**
 *
 * @author micamicu
 */
public class ServiceErrors {
    
    private List<ServiceError> errors;

    public List<ServiceError> getErrors() {
        return errors;
    }

    public void setErrors(List<ServiceError> errors) {
        this.errors = errors;
    }
}
