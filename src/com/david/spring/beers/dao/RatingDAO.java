package com.david.spring.beers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.david.spring.beers.dto.Beer;

@Component("ratingDAO")
public class RatingDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public int getRating(Beer beer) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("beer_id", beer.getId());
		List<Integer> ratings = jdbc.query("select * from beer_rating where beer_id=:beer_id", params, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int numRow) throws SQLException {
				int rating = rs.getInt("rating");
				return rating;
			}
		});
		int rating = 0;
		for (int i : ratings) {
			System.out.println(i + ", ");
			rating += i;
		}
		return rating / ratings.size();
	}

	public void insertRating(String username, Beer beer) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		System.out.println(beer.getId());
		params.addValue("beerId", beer.getId());
		params.addValue("rating", beer.getRating());
		jdbc.update("insert into beer_rating (username, beer_id, rating) values(:username, :beerId, :rating);", params);
	}

}
