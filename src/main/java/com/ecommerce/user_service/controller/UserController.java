package com.ecommerce.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 🔥 THIS IS IMPORTANT
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // (optional login)
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}