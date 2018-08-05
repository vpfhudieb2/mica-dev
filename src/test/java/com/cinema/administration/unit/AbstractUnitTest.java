/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.administration.unit;

import com.cinema.administration.unit.config.ServicesConfig;
import com.cinema.administration.common.stubs.StubsConfig;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author micamicu
 */
@ContextConfiguration(classes = {ServicesConfig.class, StubsConfig.class})
public class AbstractUnitTest {
    
}
