/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.exceptions.impl;

import com.cinamea.administration.dtos.impl.errors.ServiceErrorType;
import com.cinamea.administration.exceptions.BaseException;

/**
 *
 * @author micamicu
 */
public class NotFoundException extends BaseException{

    public NotFoundException(String objectName, String objectValue) {
        super(ServiceErrorType.NOT_FOUND, ServiceErrorType.NOT_FOUND.getMessageCode(), objectName, objectValue);
    }
}
