package com.soap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "assign4", name = "packet")
public class Packet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "packet_id", unique = true, nullable = false)
	private long id;

	@Column(name = "pack_name", nullable = false)
	private String packName;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne
	private User sender;

	@OneToOne
	private User receiver;

	@Column(name = "sender_city", nullable = false)
	private String senderCity;

	@Column(name = "destination_city", nullable = false)
	private String destinationCity;

	@Column(name = "tracking", nullable = false)
	private boolean tracking;

	@OneToMany(mappedBy = "routePack", cascade = CascadeType.ALL)
	private List<Route> packRoute = new ArrayList<>();

	public Packet() {
	}

	public Packet(String packName, String description, User sender, User receiver, String senderCity,
			String destinationCity, boolean tracking) {
		this.packName = packName;
		this.description = description;
		this.sender = sender;
		this.receiver = receiver;
		this.senderCity = senderCity;
		this.destinationCity = destinationCity;
		this.tracking = tracking;
	}

	public List<Route> getPackRoute() {
		return packRoute;
	}

	public void setPackRoute(List<Route> packRoute) {
		this.packRoute = packRoute;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public boolean isTracking() {
		return tracking;
	}

	public void setTracking(boolean tracking) {
		this.tracking = tracking;
	}

}
