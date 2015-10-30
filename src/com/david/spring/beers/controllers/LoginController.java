package com.david.spring.beers.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.spring.beers.dto.User;
import com.david.spring.beers.services.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newAccount";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showLogout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		if (result.hasErrors())
			return "newAccount";
		
		user.setAuthority("user");
		user.setEnabled(true);
		
		if (userService.existsUsername(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "The username already exists.");
			return "newAccount";
		}
		
		if (userService.existsEmail(user.getEmail())) {
			result.rejectValue("email", "DuplicateKey.user.email", "The email address already exists.");
			return "newAccount";
		}
		
		try {
			userService.createUser(user);
		} catch(DuplicateKeyException e) {
			return "newaccount";
		}
		
		return "beers";
	}

}
