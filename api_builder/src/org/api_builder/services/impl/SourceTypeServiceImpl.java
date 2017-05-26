package org.api_builder.services.impl;

import org.api_builder.beans.SourceType;
import org.api_builder.dao.SourceTypeDao;
import org.api_builder.dao.impl.SourceTypeDaoImpl;
import org.api_builder.services.SourceTypeService;

public class SourceTypeServiceImpl implements SourceTypeService {
	
	private SourceTypeDao dao;
	
	public SourceTypeServiceImpl() {
		dao = new SourceTypeDaoImpl();
	}

	@Override
	public SourceType saveSourceType(SourceType sourceType) {
		return dao.add(sourceType);
	}

	@Override
	public SourceType getSourceTypeById(int id) {
		return dao.findById(id);
	}
}
