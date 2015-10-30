package com.david.spring.beers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println("hhhh");
		model.addAttribute("users", users);
		return "users";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "admin";
	}
}
