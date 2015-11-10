package com.david.spring.beers.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Beer {
	
	private int id;
	
	@NotNull
	@Size(min=4, max=100, message="The beer's name must be between 4 and 100 characters.")
	private String name;
	
	@NotNull
	@Size(min=2, message="The beer's origin cannot be empty.")
	private String origin;
	
	private List<Integer> grades;
	
	private String description;
	
	private MultipartFile picture;

	public Beer() {
	}
	
	public Beer(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}
	
	public Beer(String name, String origin, String description) {
		this.name = name;
		this.origin = origin;
		this.description  = description;
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

	public List<Integer> getGrades() {
		return grades;
	}

	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
}
