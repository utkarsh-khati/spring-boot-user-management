package com.spring.login.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User extends BaseModel {

    @Column(name = "email")
    @NotNull(message = "Please provide an email")
    private String email;

    @Column(name = "username")
    @NotNull(message = "Please provide your username")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotNull(message = "Please provide your password")
    @JsonIgnore
    private String password;

    @Column(name = "name")
    @NotNull(message = "*Please provide your name")
    private String name;

    @Column(name = "last_name")
    @NotNull(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    @JsonIgnore
    private boolean active;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createdDate;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public boolean getActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public LocalDateTime getCreatedDate() {
	return createdDate;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @JsonIgnore
    public User getUser() {
	return this;
    }
}
