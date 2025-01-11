package com.eeshu.springsecurity1.repository;

import com.eeshu.springsecurity1.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;



public interface CutomerRepostory extends CrudRepository<Customer,Long> {
     Optional <Customer> findByEmail(String email);
}
