package com.soap.repository;

import java.io.Serializable;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Session;

import com.soap.entity.User;
import com.soap.util.HibernateUtil;

public class UserRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	Session sessionFactory;

	public UserRepository() {
		sessionFactory = HibernateUtil.getSessionFactory().openSession();
	}

	public User getUserByUsername(String username) {
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		try {
			Query cq = sessionFactory.getNamedQuery(User.FIND_USER_BY_USERNAME);
			cq.setParameter(User.PARAM_USERNAME, username);
			return (User) cq.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("crapat find by username");
		}
		return null;
	}
}
