package com.spring.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.login.model.AuthenticatedUser;
import com.spring.login.model.User;
import com.spring.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    public User saveUser(User user) throws RuntimeException {
	user.setActive(true);
	return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) throws UsernameNotFoundException {
	User user = userRepository.findByEmail(email);

	if (user == null) {
	    throw new UsernameNotFoundException("The mail " + email + " can't be found");
	}
	return user;
    }

    public AuthenticatedUser loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByEmail(username);

	if (user == null) {
	    throw new UsernameNotFoundException("The mail " + username + " can't be found");
	}

	return new AuthenticatedUser(user);
    }
}
