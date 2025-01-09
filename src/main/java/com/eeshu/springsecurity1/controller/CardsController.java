package com.eeshu.springsecurity1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CardsController {
 @GetMapping("/mycards")
    public String sayWelcome() {
        return "Here are the cards details from the db";
        
    }
}
