package org.example.registerlogin.Service;

import org.example.registerlogin.Entity.User;
import org.example.registerlogin.Repository.UserRepository;
import org.example.registerlogin.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Register user
    @Transactional
    public User register(User user) {
        return userRepository.save(user);
    }

    // Login user
    public Boolean login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findById(loginRequest.getEmailid());

        if (!user.isPresent()) {
            return false;
        }
        User user1 = user.get();
        if (!user1.getPassword().equals(loginRequest.getPassword())) {
            return false;
        }
        return true;
    }
}
