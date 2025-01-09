package com.eeshu.springsecurity1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Contactcontroller {
 @GetMapping("/contact")
    public String getContactsDetails() {
        return "here are the contact details from the db";
        
    }
}
