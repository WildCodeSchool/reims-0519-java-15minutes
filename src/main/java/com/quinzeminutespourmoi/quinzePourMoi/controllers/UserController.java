package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {
    @Autowired
    private UserRepository userRepository;



    @PostMapping("/subscribe")
    public User subscribe(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail,
            @RequestParam String password, @RequestParam String role) {
        return userRepository.save(new User(firstname, lastname, password, mail, role));
        
    }

}
