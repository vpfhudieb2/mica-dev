/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author micamicu
 */
public abstract class AbstractEntity implements Serializable{

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        
        if(!(obj instanceof AbstractEntity))
            return false;
        
        AbstractEntity temp = (AbstractEntity) obj;
        
        if(temp.getId() == null || this.getId() == null)
            return false;
        
        return temp.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    
    protected abstract Object getId();
}
