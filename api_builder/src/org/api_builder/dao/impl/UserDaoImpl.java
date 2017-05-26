package org.api_builder.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.api_builder.beans.User;
import org.api_builder.dao.UserDao;
import org.api_builder.filters.UserFilter;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class UserDaoImpl implements UserDao{
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User findById(int id) {
		return HiberUtil.getSession().load(User.class, id);
	}

	@Override
	public User findByUserId(String userId) {
		logger.debug("User id : " + userId);
		TypedQuery<User> query = HiberUtil.getSession().createQuery("from User where userid = :userid");
		query.setParameter("userid", userId);
		return query.getSingleResult();
	}

	@Override
	public User addUser(User newUser) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(newUser);
		tran.commit();
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = HiberUtil.getSession().createQuery("from User");
		return query.getResultList();
	}

}
