package com.eeshu.springsecurity1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NoticeController {
 @GetMapping("/notices")
    public String getNotices() {
        return "here are all the notices form the db";
        
    }
}
