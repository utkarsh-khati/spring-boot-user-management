package com.spring.login.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserManagementController {

    @GetMapping({"/login"})
    public String login() {
	return "login";
    }
    
    @GetMapping({"/hello","/"})
    public String hello() {
	return "hello";
    }
}
