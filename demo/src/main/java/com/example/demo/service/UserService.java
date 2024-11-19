package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public ResponseEntity<?> registerUser(User user) {
        // Log the email being passed for registration
        System.out.println("Registering user with email: " + user.getEmail());

        // Check if user with the same email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists with this email");
        }
        // Save the new user
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
