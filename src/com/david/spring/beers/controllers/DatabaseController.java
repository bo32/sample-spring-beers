package com.david.spring.beers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseController {
	
	@RequestMapping("/database")
	public String showDatabase() {
		return "database";
	}
	

}
