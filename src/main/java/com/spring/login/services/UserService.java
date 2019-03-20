package com.spring.login.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.login.model.User;

public interface UserService extends UserDetailsService {
    User findByEmail(String email) throws UsernameNotFoundException;

    User saveUser(User user) throws RuntimeException;
}
