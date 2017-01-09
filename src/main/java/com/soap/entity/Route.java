package com.soap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "assign4", name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String date;

	@Column
	private String city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packet_id", nullable = false)
	private Packet routePack;

	public Route() {
	}

	public Route(String date, String city, Packet routePack) {
		this.date = date;
		this.city = city;
		this.routePack = routePack;
	}

	public Packet getRoutePack() {
		return routePack;
	}

	public void setRoutePack(Packet routePack) {
		this.routePack = routePack;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
