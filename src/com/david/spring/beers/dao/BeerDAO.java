package com.david.spring.beers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.david.spring.beers.dto.Beer;

@Component("beerDAO")
public class BeerDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public Beer getBeer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from beer where id=:id", params, new RowMapper<Beer>() {
			public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Beer b = new Beer();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setOrigin(rs.getString("origin"));
				b.setDescription(rs.getString("description"));
				byte[] bytes = rs.getBytes("picture");
				b.setPictureBytes(bytes);
				return b;
			}
		});
	}
	
	public String getBeerImage(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from beer where id=:id", params, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("picture");
			}
		});
	}
	
	public List<Beer> getBeers() {
		return jdbc.query("select * from beer", new RowMapper<Beer>() {
			public Beer mapRow(ResultSet rs, int numRow) throws SQLException {
				Beer b = new Beer();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setOrigin(rs.getString("origin"));
				b.setDescription(rs.getString("description"));
				return b;
			}
		});
	}

	public int insertBeer(Beer beer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(beer);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbc.update("insert into beer (name, origin, description, picture) values(:name, :origin, :description, :picture);", params, holder);
		return holder.getKey().intValue();
	}

	public void removeBeer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from beer where id=:id", params);
	}

	public void updateBeer(Beer beer) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", beer.getId());
		params.addValue("name", beer.getName());
		params.addValue("origin", beer.getOrigin());
		params.addValue("description", beer.getDescription());
		jdbc.update("update beer set name=:name, origin=:origin description=:description where id=:id", params);
	}

}
