package com.soap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "sender")
	private List<Packet> packsSent;

	@OneToMany(mappedBy = "receiver")
	private List<Packet> packsReceived;

	public User() {
	}

	public User(String username, UserRole userRole, String password, List<Packet> packsSent,
			List<Packet> packsReceived) {
		super();
		this.username = username;
		this.userRole = userRole;
		this.password = password;
		this.packsSent = packsSent;
		this.packsReceived = packsReceived;
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

	public List<Packet> getPacksSent() {
		return packsSent;
	}

	public void setPacksSent(List<Packet> packsSent) {
		this.packsSent = packsSent;
	}

	public List<Packet> getPacksReceived() {
		return packsReceived;
	}

	public void setPacksReceived(List<Packet> packsReceived) {
		this.packsReceived = packsReceived;
	}
}