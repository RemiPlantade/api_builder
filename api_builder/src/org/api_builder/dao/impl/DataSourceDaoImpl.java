package org.api_builder.dao.impl;

import org.api_builder.beans.DataSource;
import org.api_builder.dao.DataSourceDao;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataSourceDaoImpl implements DataSourceDao{

	public DataSourceDaoImpl() {
		super();
	}

	@Override
	public DataSource findById(int id) {
		return HiberUtil.getSession().load(DataSource.class, id);
	}

	@Override
	public DataSource add(DataSource dataSource) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(dataSource);
		tran.commit();
		return dataSource; 
	}
}
