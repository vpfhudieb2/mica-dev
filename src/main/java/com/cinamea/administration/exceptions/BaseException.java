/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.exceptions;

import com.cinamea.administration.dtos.impl.errors.ServiceErrorType;

/**
 *
 * @author micamicu
 */
public abstract class BaseException extends Exception{
    
    private ServiceErrorType serviceErrorType;
    private String messageCode;
    private Object[] messageParams;

    public BaseException(ServiceErrorType serviceErrorType, String messageCode, Object... messageParams) {
        this.serviceErrorType = serviceErrorType;
        this.messageCode = messageCode;
        this.messageParams = messageParams;
    }

    public ServiceErrorType getServiceErrorType() {
        return serviceErrorType;
    }

    public void setServiceErrorType(ServiceErrorType serviceErrorType) {
        this.serviceErrorType = serviceErrorType;
    }
    
    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Object[] getMessageParams() {
        return messageParams;
    }

    public void setMessageParams(Object[] messageParams) {
        this.messageParams = messageParams;
    }
}
