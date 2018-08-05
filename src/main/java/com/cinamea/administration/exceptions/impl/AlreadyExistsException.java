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
public class AlreadyExistsException extends BaseException{
    
    public AlreadyExistsException(String objectName, String uniqueColumnName, String nonUniqueValue) {
        super(ServiceErrorType.ALREADY_EXISTS, ServiceErrorType.ALREADY_EXISTS.getMessageCode(), objectName, uniqueColumnName, nonUniqueValue);
    }
}
