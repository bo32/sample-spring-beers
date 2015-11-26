package com.david.spring.beers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.david.spring.beers.dao.UserDAO;
import com.david.spring.beers.dto.User;

@Service("userService")
public class UserService {

	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void createUser(User user) {
		userDAO.createUser(user);
	}

	public boolean existsUsername(String username) {
		return userDAO.existsUsername(username);
	}

	public boolean existsEmail(String email) {
		return userDAO.existsEmail(email);
	}
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	public String getConnectedUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
