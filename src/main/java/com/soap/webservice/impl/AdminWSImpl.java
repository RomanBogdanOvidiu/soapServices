package com.soap.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.soap.entity.Packet;
import com.soap.entity.Route;
import com.soap.repository.PacketRepository;
import com.soap.repository.UserRepository;
import com.soap.webservice.AdminWS;

@WebService(endpointInterface = "com.soap.webservice.AdminWS")
public class AdminWSImpl implements AdminWS {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PacketRepository packetRepository;

	@Override
	public void removePack(long id) {
		packetRepository.delete(id);
	}

	@Override
	public Packet addPacket(Packet pack) {
		return packetRepository.save(pack);
	}

	@Override
	public void registerPacketForTracking(long id) {
		Packet packet = packetRepository.findOne(id);
		packet.setTracking(true);
		packetRepository.save(packet);

	}

	@Override
	public void addNewRouteToPacket(Route route, Packet pack) {
		route.setPack(pack);

	}

}
