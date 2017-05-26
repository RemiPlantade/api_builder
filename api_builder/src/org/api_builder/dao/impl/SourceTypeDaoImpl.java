package org.api_builder.dao.impl;

import org.api_builder.beans.SourceType;
import org.api_builder.dao.SourceTypeDao;
import org.api_builder.hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SourceTypeDaoImpl implements SourceTypeDao{

	public SourceTypeDaoImpl() {
		super();
	}

	@Override
	public  SourceType findById(int id) {
		return HiberUtil.getSession().load( SourceType.class, id);
	}

	@Override
	public  SourceType add( SourceType sourceType) {
		Session session = HiberUtil.getSession();
		Transaction tran = session.beginTransaction();
		session.save(sourceType);
		tran.commit();
		return sourceType; 
	}
}
