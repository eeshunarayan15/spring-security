package com.eeshu.springsecurity1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoansController {
    @PreAuthorize("hasRole('user')")
 @GetMapping("/myloans")
    public String getLoansController() {
        return "here are the loans  from the db";
        
    }
}
