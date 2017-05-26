package org.api_builder.services.impl;

import java.util.List;

import org.api_builder.beans.Parameter;
import org.api_builder.dao.ParameterDao;
import org.api_builder.dao.impl.ParameterDaoImpl;
import org.api_builder.beans.Request;
import org.api_builder.services.ParameterService;

public class ParameterServiceImpl implements ParameterService {

	private ParameterDao paramDao;
	
	public ParameterServiceImpl() {
		paramDao = new ParameterDaoImpl();
	}
	
	@Override
	public Parameter saveParam(Parameter param) {
		return paramDao.add(param);
	}

	@Override
	public Parameter findParamById(int id) {
		return paramDao.findById(id);
	}

	@Override
	public List<Parameter> getParamsFromRequest(Request req) {
		return paramDao.fromRequest(req);
	}

}
