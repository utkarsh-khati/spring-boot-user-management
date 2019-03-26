package com.spring.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.login.model.User;

public interface UserService extends UserDetailsService {
	User saveUser(User user);

	User findUserByEmail(String email);
}