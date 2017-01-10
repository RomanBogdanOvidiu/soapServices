package com.soap.webservice.impl;

import java.util.ArrayList;

import javax.jws.WebService;

import com.soap.entity.Packet;
import com.soap.entity.PacketList;
import com.soap.entity.Route;
import com.soap.repository.BaseRepository;
import com.soap.repository.PacketRepository;
import com.soap.webservice.AdminWS;

@WebService(endpointInterface = "com.soap.webservice.AdminWS")
public class AdminWSImpl implements AdminWS {

	private BaseRepository bs = new BaseRepository();
	private PacketRepository pr = new PacketRepository();

	@Override
	public void removePack(long id) {
		bs.delete(id);
	}

	@Override
	public Packet addPacket(Packet pack) {
		long id = bs.save(pack);
		return bs.get(Packet.class, id);
	}

	@Override
	public void registerPacketForTracking(Packet pack) {
		pack.setTracking(true);
		bs.save(pack);
	}

	@Override
	public void addNewRouteToPacket(Route r, Packet p) {
		bs.save(r);
		p.getPackRoute().add(r);
		bs.merge(p);
	}

	@Override
	public PacketList findAllPackets() {
		PacketList packetList = new PacketList();
		packetList.setPacketList((ArrayList<Packet>) bs.getAll(Packet.class));
		return packetList;
	}

}
