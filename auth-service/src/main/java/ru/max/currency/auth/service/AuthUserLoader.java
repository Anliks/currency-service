package ru.max.currency.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.max.currency.auth.model.UserEntity;
import ru.max.currency.auth.repository.AuthUserRepository;


@Component
@RequiredArgsConstructor
public class AuthUserLoader implements CommandLineRunner {

    private final AuthUserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
      repository.save(
              UserEntity.builder().userId(1).username("max").password(passwordEncoder.encode("max123")).build()
      );
      repository.save(
              UserEntity.builder().userId(2).username("vlad").password(passwordEncoder.encode("vlad123")).build()
      );
    }
}
