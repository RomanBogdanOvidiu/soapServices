package com.soap.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.soap.entity.Packet;
import com.soap.entity.User;

@WebService
@SOAPBinding
public interface UserWS {

	@WebMethod
	User authenticateUser(String username, String password);

	@WebMethod
	List<User> findAllUsers();

	@WebMethod
	boolean checkStatusByName(String name);

	@WebMethod
	Packet searchForPacket(String packetName);

	@WebMethod
	User registerUser(User user);
}
