package com.david.spring.beers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.david.spring.beers.dto.User;

@Component("userDAO")
public class UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public void createUser(User user) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
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

	public User getUser(String username) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		return jdbc.queryForObject("select u.username, u.password, a.authority from users u, authorities a where u.username=:username and a.username = u.username", params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAuthority(rs.getString("authority"));
				return u;
			}
		});
	}	

}
