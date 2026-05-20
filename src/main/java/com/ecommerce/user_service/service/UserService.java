package com.ecommerce.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ LOGIN METHOD
    public String login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return "Login Successful";
            } else {
                return "Wrong Password";
            }
        } else {
            return "User Not Found";
        }
    }

    // 🔥 ADD THIS METHOD (VERY IMPORTANT)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    
    
}