package com.soap.webservice.impl;

import javax.jws.WebService;

import com.soap.entity.Packet;
import com.soap.entity.Route;
import com.soap.repository.BaseRepository;
import com.soap.webservice.AdminWS;

@WebService(endpointInterface = "com.soap.webservice.AdminWS")
public class AdminWSImpl implements AdminWS {

	private BaseRepository bs = new BaseRepository();

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

}
