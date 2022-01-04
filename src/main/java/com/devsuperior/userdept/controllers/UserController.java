package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        List<User> listUsers = userRepository.findAll();
        return listUsers;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @PostMapping
    public User insertUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }


}
