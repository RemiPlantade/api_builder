package org.api_builder.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.api_builder.beans.Api;
import org.api_builder.beans.User;
import org.api_builder.dao.ApiDao;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApiDaoImpl implements ApiDao{

	public ApiDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Api getByName(String name, User user) {
		TypedQuery<Api> query = HiberUtil.getSession().createQuery("from Api where owner = :owner and name = :name");
		query.setParameter("owner", user).setParameter("name", name);
		return query.getSingleResult();
	}

	@Override
	public List<Api> getAllApiForUser(User user) {
		TypedQuery<Api> query = HiberUtil.getSession().createQuery("from Api where owner = :owner");
		query.setParameter("owner", user);
		return query.getResultList();
	}

	@Override
	public List<Api> getAllApiForUserId(String userId) {
		TypedQuery<Api> query = HiberUtil.getSession().createQuery("from Api as api where api.owner.userid = :userid");
		query.setParameter("userid", userId);
		return query.getResultList();
	}

	@Override
	public Api add(Api api) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(api);
		tran.commit();
		return api; 
	}
}
