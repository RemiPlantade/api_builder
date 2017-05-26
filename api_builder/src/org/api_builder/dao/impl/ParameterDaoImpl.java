package org.api_builder.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;
import org.api_builder.dao.ParameterDao;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParameterDaoImpl implements ParameterDao {

	@Override
	public Parameter add(Parameter param) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(param);
		tran.commit();
		return param;
	}

	@Override
	public Parameter findById(int id) {
		return HiberUtil.getSession().load(Parameter.class, id);
	}

	@Override
	public List<Parameter> fromRequest(Request req) {
		TypedQuery<Parameter> query = HiberUtil.getSession().createQuery("select parameters from Request req where req.id = :id");
		query.setParameter("id", req.getId());
		return query.getResultList();
	}

}
