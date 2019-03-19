package com.spring.login.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.login.model.AuthenticatedUser;

public class UserServiceImpl implements UserService {

    @Override
    public AuthenticatedUser loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

}
