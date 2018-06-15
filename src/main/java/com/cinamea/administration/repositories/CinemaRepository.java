/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.repositories;

import com.cinamea.administration.entities.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author micamicu
 * @param <E>
 * @param <I>
 */
@NoRepositoryBean
public interface CinemaRepository<E extends AbstractEntity, I extends Object> extends CrudRepository<E, I>{
    
}
