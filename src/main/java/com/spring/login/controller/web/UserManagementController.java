package com.spring.login.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.login.model.User;
import com.spring.login.services.UserService;

@Controller
public class UserManagementController {

    @Autowired
    private UserService userService;

    @GetMapping(value = { "/", "/login" })
    public String login() {
	return "login";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findByEmail(auth.getName());
	model.addAttribute("userName",
		"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	return "home";
    }

    @GetMapping({ "/hello" })
    public String hello() {
	return "hello";
    }

    // @RequestMapping(value="/registration", method = RequestMethod.GET)
    // public ModelAndView registration(){
    // ModelAndView modelAndView = new ModelAndView();
    // User user = new User();
    // modelAndView.addObject("user", user);
    // modelAndView.setViewName("registration");
    // return modelAndView;
    // }
    //
    // @RequestMapping(value = "/registration", method = RequestMethod.POST)
    // public ModelAndView createNewUser(@Valid User user, BindingResult
    // bindingResult) {
    // ModelAndView modelAndView = new ModelAndView();
    // User userExists = userService.findUserByEmail(user.getEmail());
    // if (userExists != null) {
    // bindingResult
    // .rejectValue("email", "error.user",
    // "There is already a user registered with the email provided");
    // }
    // if (bindingResult.hasErrors()) {
    // modelAndView.setViewName("registration");
    // } else {
    // userService.saveUser(user);
    // modelAndView.addObject("successMessage", "User has been registered
    // successfully");
    // modelAndView.addObject("user", new User());
    // modelAndView.setViewName("registration");
    //
    // }
    // return modelAndView;
    // }
}
