package com.soap.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soap.util.HibernateUtil;

public class BaseRepository implements Serializable {

	/**
	 *
	 */
	Session sessionFactory;

	public BaseRepository() {
		sessionFactory = HibernateUtil.getSessionFactory().openSession();
	}

	private static final long serialVersionUID = 4242960948584399415L;

	public <T> Long save(final T o) {
		Transaction tx2 = sessionFactory.beginTransaction();
		long id = (long) sessionFactory.save(o);
		tx2.commit();
		return id;

	}

	public void delete(final Object object) {
		try {
			Transaction tx = sessionFactory.beginTransaction();
			sessionFactory.delete(object);
			tx.commit();
			System.out.println("DELETED");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}

	/***/
	public <T> T get(final Class<T> type, final long id) {
		return sessionFactory.get(type, id);
	}

	/***/
	@SuppressWarnings("unchecked")
	public <T> T merge(final T o) {
		Transaction tx = sessionFactory.beginTransaction();
		T t = (T) sessionFactory.merge(o);
		tx.commit();
		return t;
	}

	/***/
	public <T> void saveOrUpdate(final T o) {
		sessionFactory.saveOrUpdate(o);
	}

	public <T> List<T> getAll(final Class<T> type) {
		final Criteria crit = sessionFactory.createCriteria(type);
		return crit.list();
	}
}