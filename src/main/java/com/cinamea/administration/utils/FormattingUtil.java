/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.utils;

import java.util.Objects;

/**
 *
 * @author micamicu
 */
public class FormattingUtil {
    
    public static String formatValidatorErrorCode(String validatorName, String fieldName){
        Objects.requireNonNull(validatorName);
        Objects.requireNonNull(fieldName);
        
        return validatorName.toLowerCase()+"."+fieldName;
    }
}
