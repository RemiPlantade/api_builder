package org.api_builder.services.impl;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.Request;
import org.api_builder.dao.RequestDao;
import org.api_builder.dao.impl.RequestDaoImpl;
import org.api_builder.services.RequestService;

public class RequestServiceImpl implements RequestService {
	private RequestDao reqDao;
	
	public RequestServiceImpl() {
		this.reqDao = new RequestDaoImpl();
	}
	
	@Override
	public Request saveRequest(Request req) {
		return reqDao.add(req);
	}

	@Override
	public Request getRequestById(int id) {
		return reqDao.findById(id);
	}

	@Override
	public List<Request> getAllRequestFromAPI(Api api) {
		return reqDao.getAllFromAPI(api);
	}

	@Override
	public Request getRequestByUriAndApi(String uri, Api api) {
		for(Request req : getAllRequestFromAPI(api)){
			if(req.getUri().equals(uri)){
				return req;
			}
		}
		return null;
	}



}
