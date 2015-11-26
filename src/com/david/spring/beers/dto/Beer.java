package com.david.spring.beers.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="beer")
public class Beer {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	@Size(min=4, max=100, message="The beer's name must be between 4 and 100 characters.")
	private String name;
	
	@Column(name="origin")
	@NotNull
	@Size(min=2, message="The beer's origin cannot be empty.")
	private String origin;
	
	@OneToMany
	private List<Integer> ratings;
	
	@Column(name="description")
	private String description;
	
	@Column(name="picture")
	private MultipartFile picture;
	private byte[] pictureBytes;
	private int rating;

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
		return ratings;
	}

	public void setGrades(List<Integer> grades) {
		this.ratings = grades;
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

	public byte[] getPictureBytes() {
		return pictureBytes;
	}

	public void setPictureBytes(byte[] pictureBytes) {
		this.pictureBytes = pictureBytes;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
