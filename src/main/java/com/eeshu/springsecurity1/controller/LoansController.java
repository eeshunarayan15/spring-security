package com.eeshu.springsecurity1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoansController {
 @GetMapping("/myloans")
    public String getLoansController() {
        return "here are the loans  from the db";
        
    }
}
