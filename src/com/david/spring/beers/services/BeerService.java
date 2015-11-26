package com.david.spring.beers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.beers.dao.BeerDAO;
import com.david.spring.beers.dto.Beer;

@Service("beerService")
public class BeerService {
	private BeerDAO beerDAO;
	
	@Autowired
	public void setBeerDAO(BeerDAO beerDAO) {
		this.beerDAO = beerDAO;
	}
	
	public List<Beer> getBeers() {
		return beerDAO.getBeers();
	}
	
	public void createBeer(Beer beer) {
		beerDAO.insertBeer(beer);
	}

	public int insertBeer(Beer beer) {
		return beerDAO.insertBeer(beer);
	}

	public Beer getBeer(int id) {
		return beerDAO.getBeer(id);
	}

	public void removeBeer(int id) {
		beerDAO.removeBeer(id);
	}

	public void updateBeer(Beer beer) {
		beerDAO.updateBeer(beer);
	}

	public String getBeerImage(int id) {
		return beerDAO.getBeerImage(id);
	}

}
