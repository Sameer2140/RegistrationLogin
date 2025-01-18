package org.example.registerlogin.Controller;

import org.example.registerlogin.Entity.User;
import org.example.registerlogin.Request.LoginRequest;
import org.example.registerlogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController {

    @Autowired
    private UserService userService;

    // Creating an API for Register
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    // Login API
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
