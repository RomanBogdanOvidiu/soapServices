package com.soap.entity;

import java.util.ArrayList;

public class UserList {

	private ArrayList<User> user;

	public UserList() {
		this.user = new ArrayList<>();
	}

	public ArrayList<User> getUser() {
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}

}
