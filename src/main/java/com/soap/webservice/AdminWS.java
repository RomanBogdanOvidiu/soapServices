package com.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.soap.entity.Packet;
import com.soap.entity.Route;

@WebService
@SOAPBinding
public interface AdminWS {

	@WebMethod
	void removePack(long id);

	@WebMethod
	Packet addPacket(Packet pack);

	@WebMethod
	void registerPacketForTracking(long packetId);

	@WebMethod
	void addNewRouteToPacket(Route route, Packet pack);
}
