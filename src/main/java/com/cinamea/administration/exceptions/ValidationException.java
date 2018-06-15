/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.exceptions;

import org.springframework.validation.BindingResult;

/**
 *
 * @author micamicu
 */
public class ValidationException extends RuntimeException{
    
    private final BindingResult bindingResult;
    
    public ValidationException(BindingResult bindingResult){
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
