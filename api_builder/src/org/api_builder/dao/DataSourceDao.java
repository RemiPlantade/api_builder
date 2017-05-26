package org.api_builder.dao;

import org.api_builder.beans.DataSource;

public interface DataSourceDao {
	public DataSource findById(int id);
	public DataSource add(DataSource dataSource);
	
}
