package com.david.spring.beers.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Beer {
	private int id;
	@NotNull
	@Size(min=4, max=100, message="The beer's name must be between 4 and 100 characters.")
	private String name;
	@NotNull
	@Size(min=2, message="The beer's origin cannot be empty.")
	private String origin;
	
	public Beer() {
	}
	
	public Beer(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
