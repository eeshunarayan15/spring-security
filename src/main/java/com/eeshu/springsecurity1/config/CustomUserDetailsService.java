package com.eeshu.springsecurity1.config;

import com.eeshu.springsecurity1.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eeshu.springsecurity1.repository.CutomerRepostory;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    // @Autowired
    private  final CutomerRepostory cutomerRepostory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


     Customer customer= cutomerRepostory.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user" + username));
        List<GrantedAuthority>authorities=List.of(new SimpleGrantedAuthority(customer.getRole()));
     return  new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}
