/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.repositories;

import com.cinamea.administration.entities.impl.CinemaCountryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author micamicu
 */
@Repository
public interface CinemaCountryRepository extends CinemaRepository<CinemaCountryEntity, Long>{
    
    @Query(value = "select * from cinema_countries cc join cinema_brands cb on cc.cinema_brand_id = cb.id and cb.id = ?1 and cc.country_code=?2",
            nativeQuery = true)
    CinemaCountryEntity getByCinemaBrandIdAndCountryCode(Long cinemaBrandId, String countryCode);
}
