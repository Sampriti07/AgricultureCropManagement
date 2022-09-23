package com.capg.agriculture.security.service;

import java.util.ArrayList;

//import com.cg.UserService.secuirity.model.SecUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.agriculture.Repository.FarmerRepository;


    @Service
    public class MyUserDetailsService implements UserDetailsService {
        @Autowired
        FarmerRepository prepo;
        @Override
        @Transactional
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
           
            return new User("test@test","hello", new ArrayList<>());
        }
    }