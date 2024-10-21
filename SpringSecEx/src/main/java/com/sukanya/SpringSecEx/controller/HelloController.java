package com.sukanya.SpringSecEx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    //want to print the session ID
    public String greet(HttpServletRequest request){
        return "Welcome to my Home Page" + request.getSession().getId();
    }
}
