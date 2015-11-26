package com.david.spring.beers.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="beer_rating")
public class BeerRating {
	@Column(name="beer_id")
	@ManyToOne
	private int beerId;
	
	@Column(name="username")
	@ManyToOne
	private String username;
	
	@Column(name="rating")
	private int rating;
	
	public BeerRating() {
	}
	
	public BeerRating(int beerId, String username, int rating) {
		this.beerId = beerId;
		this.username = username;
		this.rating = rating;
	}
	
	public int getBeerId() {
		return beerId;
	}
	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
