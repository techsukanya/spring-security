package com.sukanya.SpringSecEx.controller;

import com.sukanya.SpringSecEx.model.Users;
import com.sukanya.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//Spring security Bcrypt password encoder
@RestController
public class UserController {
    @Autowired
    private UserService userservice;
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userservice.register(user);
    }
   @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userservice.verify(user);
   }
}
