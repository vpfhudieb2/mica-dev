/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.repositories;

import com.cinamea.administration.entities.impl.CinemaBrandEntity;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author micamicu
 */
@Repository
public interface CinemaBrandRepository extends CinemaRepository<CinemaBrandEntity, Long>{
    
    CinemaBrandEntity getByNameIgnoreCase(String name);
}
