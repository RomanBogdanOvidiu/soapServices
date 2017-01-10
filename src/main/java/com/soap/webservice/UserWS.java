package com.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.soap.entity.Packet;
import com.soap.entity.PacketList;
import com.soap.entity.User;
import com.soap.entity.UserList;

@WebService
@SOAPBinding
public interface UserWS {

	@WebMethod
	User authenticateUser(String username, String password);

	@WebMethod
	UserList findAllUsers();

	@WebMethod
	boolean checkStatus(long name);

	@WebMethod
	Packet searchForPacket(long packetName);

	@WebMethod
	User registerUser(User user);

	@WebMethod
	PacketList findMyPackets(String username);

	@WebMethod
	User getTheUser(String user);
}
