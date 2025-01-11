package com.eeshu.springsecurity1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "customer")
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String email;
    private String pwd;
    @Column(name = "role")
    private String role;

}
