package com.ecommerce.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    // 🔹 Signup
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return "❌ Email already exists";
        }

        userRepo.save(user);
        return "✅ User registered successfully";
    }

    // 🔹 Login
    @PostMapping("/login")
    public Object login(@RequestBody User user) {

        Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());

        if (optionalUser.isEmpty()) {
            return "❌ User not found";
        }

        User existing = optionalUser.get();

        if (!existing.getPassword().equals(user.getPassword())) {
            return "❌ Invalid password";
        }

        return existing; // ✅ frontend ko userId milega
    }
}