package ru.max.currency.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.max.currency.auth.model.UserEntity;
import ru.max.currency.auth.repository.AuthUserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthUserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;



    public String saveUser(UserEntity credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        System.out.println(credential.getPassword());
        credential.setUserId(3);
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        Optional<UserEntity> user = repository.findByUsername(username);
        return jwtService.generateToken(username, user.get().getUserId());
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}