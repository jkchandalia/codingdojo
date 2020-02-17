package com.codingdojo.authentications.controllers;

import java.util.List;

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

import com.codingdojo.authentications.models.Task;
import com.codingdojo.authentications.models.User;
import com.codingdojo.authentications.services.TaskService;
import com.codingdojo.authentications.services.UserService;

// imports removed for brevity
@Controller
public class UserController {
	private final UserService userService;
	private final TaskService taskService;
    
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }
    
    @RequestMapping("/auth")
    public String registerForm(@ModelAttribute("user") User user) {
        return "authPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "redirect:/auth";
    }
    
    @RequestMapping(value="/auth", method=RequestMethod.POST)
    public String registerUser(
    		@Valid @ModelAttribute("user") User user, 
    		BindingResult result, 
    		HttpSession session,
    		RedirectAttributes redirectAttr) {
//    	 if result has errors, return the registration page (don't worry about validations just now)
//         else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if (result.hasErrors()){
    		return "authPage.jsp";
    		}
    	else if (user.getPassword().equals(user.getPasswordConfirmation())) {
    		System.out.println("got here!");
    		User new_user = userService.registerUser(user);
    		session.setAttribute("loggedIn", true);
    		session.setAttribute("userId", new_user.getId());
    		return "redirect:/tasks";}
    	else {
    		redirectAttr.addFlashAttribute("error", "Password and confirmation do not match.");
    		return "redirect:/auth";
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
		return "redirect:/tasks";
    	}
		return "redirect:/auth";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }

    @RequestMapping("/tasks")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	List<Task> tasks = taskService.allTasks();
    	model.addAttribute("tasks", tasks);
    	return "tasks/allTasks.jsp";
    }
    
    @RequestMapping("/tasks/new")
    public String newTask(HttpSession session, Model model, @ModelAttribute("task") Task task) {
        // get user from session, save them in the model and return the home page
    	if (!session.getAttribute("loggedIn").equals(true)) {
    		return "redirect:/auth";
    	}
    	else {
    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	return "tasks/newTask.jsp";}
    }
    
    @RequestMapping(value = "/tasks/new", method=RequestMethod.POST)
    public String createTask(HttpSession session, 
    		Model model, 
    		@Valid @ModelAttribute("task") Task task,
    		BindingResult result) {
        // get user from session, save them in the model and return the home page
    	if (result.hasErrors()){
    		List<User> users = userService.allUsers();
        	model.addAttribute("users", users);
    		return "tasks/newTask.jsp";
    		}
    	Long id = (Long) session.getAttribute("userId");
    	User creator = userService.findUserById(id);
    	System.out.println(id);
    	System.out.println(task.getAssignee_id());
    	User assignee = userService.findUserById(task.getAssignee_id());
    	task.setAssignee(assignee);
    	task.setCreator(creator);
    	taskService.createTask(task);
    	return "redirect:/tasks";
    }
    
    @RequestMapping("/tasks/{task_id}")
    public String showTask(HttpSession session, 
    		Model model, 
    		@PathVariable("task_id") Long task_id) {
        // get user from session, save them in the model and return the home page
    	Task task = taskService.findTask(task_id);
    	model.addAttribute("task", task);
    	Long user_id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(user_id);
    	model.addAttribute("user", user);
    	return "tasks/oneTask.jsp";
    }
    
    @RequestMapping("/tasks/{task_id}/edit")
    public String editTask(HttpSession session, 
    		Model model, 
    		@PathVariable("task_id") Long task_id) {
        // get user from session, save them in the model and return the home page
    	Task task = taskService.findTask(task_id);
    	Long user_id = (Long) session.getAttribute("userId");
    	if (task.getCreator().getId().equals(user_id)){
    	task.setAssignee_id(task.getAssignee().getId());
    	model.addAttribute("task", task);
    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	return "tasks/editTask.jsp";}
    	else {
    		return "redirect:/tasks";
    	}
    }
    
    @RequestMapping(value="/tasks/{task_id}/edit", method=RequestMethod.PUT)
    public String updateTask(HttpSession session, 
    		Model model, 
    		@PathVariable("task_id") Long task_id,
    		@Valid @ModelAttribute("task") Task task,
    		BindingResult result,
    		RedirectAttributes redirectAttr
    		) {
    	if (result.hasErrors()){
    		redirectAttr.addFlashAttribute("error", "Task description must be longer");
    		Task original_task = taskService.findTask(task_id);
        	model.addAttribute("task", original_task);
        	List<User> users = userService.allUsers();
        	model.addAttribute("users", users);
    		return "redirect:/tasks/"+task_id+"/edit";}
        	
    	else {
    	task.setId(task_id);
    	Task original_task2 = taskService.findTask(task_id);
    	Long user_id2 = (Long) session.getAttribute("userId");
    	task.setCreator(original_task2.getCreator());
    	User assignee = userService.findUserById(task.getAssignee_id());
    	task.setAssignee(assignee);
    	taskService.updateTask(task);
    	return "redirect:/tasks";}
    }
    
    @RequestMapping(value="/tasks/{task_id}/delete", method=RequestMethod.DELETE)
    public String deleteTask(HttpSession session, 
    		Model model, 
    		@PathVariable("task_id") Long task_id) {
    	taskService.deleteTask(task_id);
    	return "redirect:/tasks";
    }
}