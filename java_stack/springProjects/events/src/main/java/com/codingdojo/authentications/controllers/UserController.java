package com.codingdojo.authentications.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.authentications.models.Event;
import com.codingdojo.authentications.models.Location;
import com.codingdojo.authentications.models.User;
import com.codingdojo.authentications.services.EventService;
import com.codingdojo.authentications.services.LocationService;
import com.codingdojo.authentications.services.MessageService;
import com.codingdojo.authentications.services.UserService;

// imports removed for brevity
@Controller
public class UserController {
	private final UserService userService;
	private final EventService eventService;
	private final MessageService messageService;
	private final LocationService locationService;
    
    public UserController(UserService userService,
    		EventService eventService,
    		MessageService messageService,
    		LocationService locationService) {
        this.locationService = locationService;
		this.messageService = messageService;
		this.userService = userService;
		this.eventService = eventService;
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
    public String registerUser(
    		@Valid @ModelAttribute("user") User user, 
    		BindingResult result, 
    		HttpSession session,
    		RedirectAttributes redirectAttr) {
//    	 if result has errors, return the registration page (don't worry about validations just now)
//         else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if (result.hasErrors()){
    		return "redirect:/registration";
    		}
    	else if (user.getPassword().equals(user.getPasswordConfirmation())) {
    		Location location = locationService.findByCityAndState(user.getCityString(), user.getStateString());
    		if (location == null) {
    			Location new_location = new Location(user.getCityString(),user.getStateString());
    			Location new_loc = locationService.createLocation(new_location);
    			user.setLocation(new_loc);	
    		} else {
    			user.setLocation(location);
    		}
    		User new_user = userService.registerUser(user);
    		session.setAttribute("loggedIn", true);
    		session.setAttribute("userId", new_user.getId());
    		return "redirect:/events";}
    	else {
    		redirectAttr.addFlashAttribute("error", "Password and confirmation do not match.");
    		return "redirect:/registration";
    	}
    	}
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(
    		@RequestParam("email") String email, 
    		@RequestParam("password") String password, 
    		Model model, 
    		HttpSession session, 
    		RedirectAttributes redirectAttr) {
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
		return "redirect:/events";
    	}
		return "redirect:/login";
    }
    
    @RequestMapping("/events")
    public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	String state = user.getLocation().getState();
    	List<Object[]> events_in_state = eventService.eventAndLocationByState(state);
    	List<Object[]> events_not_in_state = eventService.eventAndLocationByNotState(state);
    	model.addAttribute("events_in_state", events_in_state);
    	model.addAttribute("events_not_in_state", events_not_in_state);
    	return "events/homePage.jsp";
    }
    @RequestMapping("/events/{event_id}")
    public String event(HttpSession session, Model model, @PathVariable("event_id") Long event_id) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "event/eventPage.jsp";
    }
    @RequestMapping("/events/{event_id}/edit")
    public String eventEdit(HttpSession session, Model model, @PathVariable("event_id") Long event_id) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "event/eventEdit.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
    @RequestMapping("/create_event")
    public String createEvent(@Valid @ModelAttribute("event") Event event, 
    		HttpSession session,
    		BindingResult result) {
    	if (result.hasErrors()){
    		return "redirect:/events";
    		}
    	else {
    		Location location = locationService.findByCityAndState(event.getCityString(), event.getStateString());
    		if (location == null) {
    			Location new_location = new Location(event.getCityString(),event.getStateString());
    			Location new_loc = locationService.createLocation(new_location);
    			event.setLocation(new_loc);	
    		} else {
    			event.setLocation(location);
    		}
    		Long user_id = (Long) session.getAttribute("userId");
    		User user = userService.findUserById(user_id);
    		event.setUser(user);
    		eventService.createEvent(event);
    		
    	}
        // invalidate session
        // redirect to login page

    	return "redirect:/events";
    }
}