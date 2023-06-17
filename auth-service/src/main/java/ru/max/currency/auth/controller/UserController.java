package ru.max.currency.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.max.currency.auth.dto.AuthRequest;
import ru.max.currency.auth.model.UserEntity;
import ru.max.currency.auth.service.AuthService;

import java.security.Principal;


@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;



    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserEntity user) {
        return service.saveUser(user);
    }


    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
