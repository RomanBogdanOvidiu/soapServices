package com.soap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "assign4", name = "user")
@NamedQueries({ @NamedQuery(name = User.FIND_USER_BY_USERNAME, query = User.QUERY_FIND_BY) })
public class User {

	public static final String FIND_USER_BY_USERNAME = "findUserByUsername";
	public static final String QUERY_FIND_BY = "Select u from User u where u.username = :" + User.PARAM_USERNAME;
	public static final String PARAM_USERNAME = "username";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "userRole", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@Column(name = "password", nullable = false)
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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