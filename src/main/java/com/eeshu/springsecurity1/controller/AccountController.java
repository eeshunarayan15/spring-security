package com.eeshu.springsecurity1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AccountController {
    @GetMapping("/account")
     @PreAuthorize("hasRole('ADMIN')")
    public String getAccoutDetails() {
        return "here are the account details from the DB";
        
    }

}
