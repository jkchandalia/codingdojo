package com.codingdojo.authentications.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.authentications.models.User;
import com.codingdojo.authentications.services.UserService;

// imports removed for brevity
@Controller
public class UserController {
	private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if (result.hasErrors()){
    		return "registrationPage.jsp";
    		}
    	else {
    		User new_user = userService.registerUser(user);
    		session.setAttribute("loggedIn", true);
    		session.setAttribute("userId", new_user.getId());
    		return "redirect:/home";
    	}
    	}
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, 
    		HttpSession session, RedirectAttributes redirectAttr) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	User user = userService.findByEmail(email);
	
		if (user==null) {
			redirectAttr.addFlashAttribute("error", "No Such User");
		}
		else if (!userService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("error", "Invalid Password");
		} else {
		session.setAttribute("userId", user.getId());
		session.setAttribute("loggedIn", true);
		return "redirect:/home";
    	}
		return "redirect:/login";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "homePage.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
}