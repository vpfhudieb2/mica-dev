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
public enum ServiceErrorType {
    
    VALIDATION(""),
    NOT_FOUND("exception.not_found"),
    ALREADY_EXISTS("exception.already_exists");
    
    
    private final String messageCode;
    
    private ServiceErrorType(String messageCode){
        this.messageCode = messageCode;
    }

    public String getMessageCode() {
        return messageCode;
    }
}
