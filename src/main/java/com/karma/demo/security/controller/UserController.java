package com.karma.demo.security.controller;

import com.karma.demo.security.SecurityConfig;
import com.karma.demo.security.model.ApplicationUser;
import com.karma.demo.security.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    SecurityConfig securityConfig;


    @PostMapping("/sign-up")
    public void signUp(@Valid @RequestBody ApplicationUser user) {
        //Hash password before save to database
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));

        applicationUserRepository.save(user);
    }
}
