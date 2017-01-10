package com.soap.entity;

import java.util.ArrayList;

public class PacketList {

	private ArrayList<Packet> packetList;

	public PacketList() {
		this.packetList = new ArrayList<>();
	}

	public ArrayList<Packet> getPacketList() {
		return packetList;
	}

	public void setPacketList(ArrayList<Packet> packetList) {
		this.packetList = packetList;
	}
}
