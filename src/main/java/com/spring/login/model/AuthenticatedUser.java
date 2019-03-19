package com.spring.login.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean isEnabled;

    public AuthenticatedUser(String username, String password, boolean isEnabled) {
	this.username = username;
	this.password = password;
	this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return new ArrayList<>();
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return isEnabled;
    }
}
