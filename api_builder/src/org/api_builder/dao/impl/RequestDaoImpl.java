package org.api_builder.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.api_builder.beans.Api;
import org.api_builder.beans.Request;
import org.api_builder.dao.RequestDao;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RequestDaoImpl implements RequestDao {

	@Override
	public Request add(Request req) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(req);
		tran.commit();
		return req;
	}

	@Override
	public Request findById(int id) {
		return HiberUtil.getSession().load(Request.class, id);
	}

	@Override
	public List<Request> getAllFromAPI(Api api) {
		TypedQuery<Request> query = HiberUtil.getSession().createQuery("from Request where api = :api");
		query.setParameter("api", api);
		return query.getResultList();
	}

}
