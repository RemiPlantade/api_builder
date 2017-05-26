package org.api_builder.services.impl;

import org.api_builder.beans.DataSource;
import org.api_builder.dao.DataSourceDao;
import org.api_builder.dao.impl.DataSourceDaoImpl;
import org.api_builder.services.DataSourceService;

public class DataSourceServiceImpl implements DataSourceService {
	
	private DataSourceDao dao;
	
	public DataSourceServiceImpl() {
		dao = new DataSourceDaoImpl();
	}

	@Override
	public DataSource getDataSourceById(int id) {
		return dao.findById(id);
	}

	@Override
	public DataSource saveDataSource(DataSource dataSource) {
		return dao.add(dataSource);
	}
	
	
}
