package com.david.spring.beers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.spring.beers.dao.GradeDAO;
import com.david.spring.beers.dto.Beer;

@Component("gradeService")
public class GradeService {
	
	private GradeDAO gradeDAO;
	
	@Autowired
	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}
	
	public int getGrade(Beer beer) {
		return gradeDAO.getAverage(beer);
	}
	

}
