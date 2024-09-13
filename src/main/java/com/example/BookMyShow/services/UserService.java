package com.example.BookMyShow.services;

import com.example.BookMyShow.controllers.UserController;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User signUp(String name, String email, String password){
        // Check if user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        // If user exists, then throw error
        if(userOptional.isPresent()){
            throw new RuntimeException("User already exists");
        }
        // Else, save new user
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User login(String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        // If user exists, then throw error
        if(userOptional.isEmpty()){
            throw new RuntimeException("User does not exist");
        }

        User user = userOptional.get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            throw new RuntimeException("Password does not match");
        }
        return user;
    }
}
