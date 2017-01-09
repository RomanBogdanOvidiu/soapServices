package com.soap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "assign4", name = "user")
public class User {

	@Id
	private String username;

	@Column(name = "userRole")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(String username, UserRole userRole, String password, List<Packet> packsSent,
			List<Packet> packsReceived) {
		super();
		this.username = username;
		this.userRole = userRole;
		this.password = password;
	}

	public User(String username, UserRole userRole, String password) {
		this.username = username;
		this.userRole = userRole;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}