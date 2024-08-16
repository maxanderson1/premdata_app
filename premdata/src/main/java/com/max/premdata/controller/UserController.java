package com.max.premdata.controller;

import com.max.premdata.entity.Users;
import com.max.premdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers(){
        List<Users> users = userService.getAllUsers();

        System.out.println(users);

        return users;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to my Spring Boot application!";
    }
}
