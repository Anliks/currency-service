package ru.max.currency.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.max.currency.auth.repository.AuthUserRepository;

@Component
public class AuthUserDetailsService implements UserDetailsService {


    @Autowired
    private AuthUserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("пользователя не существует  "));
    }
}
