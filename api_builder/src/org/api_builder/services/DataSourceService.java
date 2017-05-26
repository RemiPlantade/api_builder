package org.api_builder.services;

import org.api_builder.beans.DataSource;

public interface DataSourceService {
	public DataSource getDataSourceById(int id);
	public DataSource saveDataSource(DataSource dataSource);
	
}
