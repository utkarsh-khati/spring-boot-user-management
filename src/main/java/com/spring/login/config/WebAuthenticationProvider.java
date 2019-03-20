package com.spring.login.config;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.spring.login.model.AuthenticatedUser;

@Component
public class WebAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

	String username = authentication.getName();
	String password = String.valueOf(authentication.getCredentials());
	// AuthenticatedUser authenticatedUser = new AuthenticatedUser(username,
	// password, isEnabled);
	if (Objects.equals(username, "user")) {
	    if (Objects.equals(password, "password")) {
		return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
	    } else {
		throw new BadCredentialsException("Bad Credentials");
	    }
	} else {
	    throw new BadCredentialsException("Bad Credentials");
	}
    }

    @Override
    public boolean supports(Class<?> authentication) {
	return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }

}
