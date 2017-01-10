package com.soap.repository;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.soap.entity.Packet;
import com.soap.util.HibernateUtil;

public class PacketRepository {
	private static final long serialVersionUID = 1L;
	Session sessionFactory;

	public PacketRepository() {
		sessionFactory = HibernateUtil.getSessionFactory().openSession();
	}

	public ArrayList<Packet> getAllPackages() {
		Query<Packet> query = sessionFactory.createQuery("From Packet");
		sessionFactory.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<Packet> packages = (ArrayList<Packet>) query.list();
		sessionFactory.getTransaction().commit();
		return packages;
	}
}
