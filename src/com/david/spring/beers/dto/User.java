package com.david.spring.beers.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class User {
	
	@Size(min=3, max=30)
	@NotNull
	@Column(name="username")
	private String username;
	
	@Size(min=4, max=60)
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	private String authority;
	private boolean enabled = false;
	
	public User() {
	}
	
	public User(String username, String password, String email, String authority, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
