package com.spring.login.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.login.model.User;
import com.spring.login.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}

	@GetMapping(value = "/registration")
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping(value = "/registration")
	public String createNewUser(@Valid User user, BindingResult bindingResult,
			Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			System.out.println(user.getEmail() + " " + user.getName() + " "
					+ user.getLastName() + " " + user.getPassword() + " "
					+ user.getActive() + " " + user);
			userService.saveUser(user);
			model.addAttribute("successMessage",
					"User has been registered successfully");
			model.addAttribute("user", new User());
		}
		return "registration";
	}

	@GetMapping(value = "/home")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addAttribute("userName", "Welcome " + user.getName() + " "
				+ user.getLastName() + " (" + user.getEmail() + ")");
		model.addAttribute("adminMessage",
				"Content Available Only for Users with Admin Role");
		return "home";
	}
}
