package com.soap;

import javax.xml.ws.Endpoint;

import com.soap.webservice.impl.AdminWSImpl;
import com.soap.webservice.impl.UserWSImpl;

public class Application {

	public static void main(String[] args) throws Exception {
		Endpoint.publish("http://localhost:8888/wsadmin", new AdminWSImpl());
		Endpoint.publish("http://localhost:8888/wsuser", new UserWSImpl());
	}

}