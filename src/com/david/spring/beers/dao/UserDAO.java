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
import org.springframework.stereotype.Component;

import com.david.spring.beers.dto.User;

@Component("userDAO")
public class UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public void createUser(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username, password, enabled, email) values(:username, :password, :enabled, :email);", params);
		jdbc.update("insert into authorities (username, authority) values(:username, :authority);", params);
	}

	public boolean existsUsername(String username) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		return jdbc.queryForObject("select count(*) from users where username=:username", params, Integer.class) == 1;
	}

	public boolean existsEmail(String email) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("email", email);
		return jdbc.queryForObject("select count(*) from users where email=:email", params, Integer.class) == 1;
	}

	public List<User> getUsers() {
		String query = "select users.username, authorities.authority, users.enabled from users, authorities where authorities.username = users.username";
		return jdbc.query(query, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int numRow) throws SQLException {
				User u = new User();
				u.setUsername(rs.getString("users.username"));
				u.setAuthority(rs.getString("authorities.authority"));
				u.setEnabled(rs.getBoolean("users.enabled"));
				return u;
			}
		});
	}	

}
