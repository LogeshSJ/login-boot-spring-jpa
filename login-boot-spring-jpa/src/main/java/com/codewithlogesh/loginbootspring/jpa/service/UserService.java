package com.codewithlogesh.loginbootspring.jpa.service;

import com.codewithlogesh.loginbootspring.jpa.model.AppUser;
import com.codewithlogesh.loginbootspring.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public AppUser login(AppUser appUser) {
        AppUser loginUser = userRepository.findUserByUsernameAndPassword
                (appUser.getUsername(), appUser.getPassword());

        return loginUser;
    }

    public AppUser register(AppUser appUser) {
        userRepository.save(appUser);
        return appUser;
    }
}
