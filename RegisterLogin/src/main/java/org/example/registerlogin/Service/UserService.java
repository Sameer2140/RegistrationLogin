package org.example.registerlogin.Service;

import org.example.registerlogin.Entity.User;
import org.example.registerlogin.Repository.UserRepository;
import org.example.registerlogin.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    implement the logic for all the Service like login register etc...

//    Register
    public User register(@RequestBody User user)
    {
       return userRepository.save(user);

    }
//    Login
    public Boolean login(LoginRequest loginRequest)
    {
        Optional<User> user = userRepository.findById(loginRequest.getEmailid());

        if (user.isEmpty()) {
            return false;
        }
        User user1 = user.get();
        if(!user1.getPassword().equals(loginRequest.getPassword()))
        {
            return false;
        }
        return true;
    }

}
