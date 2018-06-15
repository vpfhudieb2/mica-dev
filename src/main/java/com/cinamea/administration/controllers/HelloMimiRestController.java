/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinamea.administration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author micamicu
 */
@Controller("hello")
@RequestMapping(path = "/hello")
public class HelloMimiRestController {
    
    @RequestMapping("/helloMimi")
    @ResponseBody
    public String sayHello(){
        return "Hello mimi";
    }
}
