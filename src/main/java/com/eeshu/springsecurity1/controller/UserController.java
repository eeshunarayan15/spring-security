package com.eeshu.springsecurity1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.eeshu.springsecurity1.model.Customer;
import com.eeshu.springsecurity1.repository.CutomerRepostory;
@RestController
public class UserController {
    @Autowired
    private CutomerRepostory cutomerRepostory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            String hashpwd = passwordEncoder.encode(customer.getPwd());
          
            customer.setPwd(hashpwd);
           
            Customer savedCustomer = cutomerRepostory.save(customer);
            if (savedCustomer.getId() > 0) {
             
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are sucessfully saved") ;
            } else {
             
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User registration failed" );
            }
        
        } catch (Exception e) {
     
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an exception occured" + e.getMessage());
       }
    }

}
