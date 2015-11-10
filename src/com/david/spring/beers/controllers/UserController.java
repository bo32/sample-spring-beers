package com.david.spring.beers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.spring.beers.dto.User;
import com.david.spring.beers.services.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired 
	public void setUserService(UserService userService) {
		this.userService = userService;	
	}
	
	@RequestMapping("/users")
	public String showUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "users";
	}
	
	@RequestMapping(value="/editUser/{username}", method=RequestMethod.GET)
	public ModelAndView editUser(@PathVariable String username) {
		System.out.println("editUser");
		ModelAndView mav = new ModelAndView("editUser");
		User u = userService.getUser(username);
		mav.addObject("user", u);
		return mav;
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "admin";
	}
}
