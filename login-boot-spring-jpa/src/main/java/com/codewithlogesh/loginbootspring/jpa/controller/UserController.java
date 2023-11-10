package com.codewithlogesh.loginbootspring.jpa.controller;

import com.codewithlogesh.loginbootspring.jpa.model.AppUser;
import com.codewithlogesh.loginbootspring.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser appUser){
        return userService.login(appUser);
    }
    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser appUser){

        return userService.register(appUser);
    }


}