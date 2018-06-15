/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers.validators.impl;

import com.cinamea.administration.controllers.validators.AbstractValidator;

/**
 *
 * @author micamicu
 */
public class RequiredValidator extends AbstractValidator{

    @Override
    protected boolean isValid(Object objectToValidate, Object... others) {

        return objectToValidate != null;

    }
}
