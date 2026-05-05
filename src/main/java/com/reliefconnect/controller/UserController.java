package com.reliefconnect.controller;

import com.reliefconnect.model.User;
import com.reliefconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "https://effulgent-haupia-2b6500.netlify.app/") 
public class UserController {

    @Autowired
    private UserService service;

    // 🔥 CREATE USER
    @PostMapping
    public User create(@RequestBody User user) {
        try {
            return service.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 🔥 GET ALL USERS
    @GetMapping
    public List<User> getAll() {
        try {
            return service.getAll();
        } catch (Exception e) {
            e.printStackTrace(); 
            throw e;
        }
    }
}