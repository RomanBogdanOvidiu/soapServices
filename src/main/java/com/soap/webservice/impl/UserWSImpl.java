package com.soap.webservice.impl;

import java.util.ArrayList;

import javax.jws.WebService;

import com.soap.entity.Packet;
import com.soap.entity.PacketList;
import com.soap.entity.User;
import com.soap.entity.UserList;
import com.soap.entity.UserRole;
import com.soap.repository.BaseRepository;
import com.soap.repository.UserRepository;
import com.soap.webservice.UserWS;

/**
 * All a Simple user can do
 *
 * @author Bogdan
 *
 */
@WebService(endpointInterface = "com.soap.webservice.UserWS")
public class UserWSImpl implements UserWS {

	private BaseRepository bs = new BaseRepository();
	UserRepository userR = new UserRepository();

	@Override
	public User authenticateUser(String username, String password) {
		User user = userR.getUserByUsername(username);
		if ((user != null) && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public UserList findAllUsers() {
		UserList userList = new UserList();
		userList.setUser((ArrayList<User>) bs.getAll(User.class));
		return userList;
	}

	@Override
	public boolean checkStatus(long id) {
		Packet p = bs.get(Packet.class, id);
		return p.isTracking();
	}

	@Override
	public Packet searchForPacket(long packetId) {
		return bs.get(Packet.class, packetId);
	}

	@Override
	public User registerUser(User user) {
		if (userR.getUserByUsername(user.getUsername()) == null) {
			user.setUserRole(UserRole.CLIENT);
			user.setId(bs.save(user));
		}
		return user;
	}

	@Override
	public PacketList findMyPackets(String username) {
		PacketList finalList = new PacketList();
		for (Packet p : bs.getAll(Packet.class)) {
			if (p.getSender().getUsername().equals(username) || p.getReceiver().getUsername().equals(username)) {
				finalList.getPacketList().add(p);
			}
		}
		return finalList;
	}

	@Override
	public User getTheUser(String user) {
		return userR.getUserByUsername(user);
	}

}
