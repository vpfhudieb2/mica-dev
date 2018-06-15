/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers.validators;

import com.cinamea.administration.controllers.validators.annotations.Required;
import com.cinamea.administration.controllers.validators.annotations.Validation;
import com.cinamea.administration.dtos.DTO;
import com.cinamea.administration.utils.FormattingUtil;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author micamicu
 */
public class AnnotationValidator implements Validator{

    @Autowired
    //@Qualifier("requiredValidator")
    private AbstractValidator requiredValidator;
    
    @Override
    public boolean supports(Class<?> clazz) {
        
        return DTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Arrays
                .stream(target.getClass().getDeclaredFields())
                .forEach(field -> {
                    Annotation[] annotations = field.getAnnotations();
                    
                    try {
                        if(annotations != null){
                            for(Annotation annotation : annotations){
                                if(annotation.annotationType().getAnnotation(Validation.class) != null){                                        
                                    field.setAccessible(true);    
                                    Object value = field.get(target);

                                    if(annotation instanceof Required){
                                        if(!requiredValidator.isValid(value)){
                                            errors.rejectValue(field.getName(), FormattingUtil.formatValidatorErrorCode(annotation.annotationType().getSimpleName(), field.getName()));
                                        }
                                    }
                                }
                            }        
                        }    
                    }
                    catch (IllegalArgumentException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });                
    }
}
