package com.soap.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.soap.entity.Packet;
import com.soap.entity.User;
import com.soap.repository.PacketRepository;
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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PacketRepository packetRepository;

	@Override
	public User authenticateUser(String username, String password) {
		User user = userRepository.findUserByUsername(username);
		if ((user != null) && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public List<Packet> getAllMyReceivedPackets(User u) {
		return u.getPacksReceived();
	}

	@Override
	public List<Packet> getAllMySentPackets(User u) {
		return u.getPacksSent();
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean checkStatusByName(String name) {
		Packet p = packetRepository.findPacketByPackName(name);
		return p.isTracking();
	}

	@Override
	public Packet searchForPacket(String packetName) {
		Packet p = packetRepository.findPacketByPackName(packetName);
		return (p != null) ? p : null;
	}

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}
}
