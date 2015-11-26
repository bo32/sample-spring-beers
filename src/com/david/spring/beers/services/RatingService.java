package com.david.spring.beers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.spring.beers.dao.RatingDAO;
import com.david.spring.beers.dto.Beer;

@Component("ratingService")
public class RatingService {
	
	private RatingDAO ratingDAO;
	
	@Autowired
	public void setRatingDAO(RatingDAO ratingDAO) {
		this.ratingDAO = ratingDAO;
	}
	
	public int getRating(Beer beer) {
		return ratingDAO.getRating(beer);
	}

	public void insertRating(String username, Beer beer) {
		ratingDAO.insertRating(username, beer);
	}
	

}
