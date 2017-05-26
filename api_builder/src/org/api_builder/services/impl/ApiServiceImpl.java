package org.api_builder.services.impl;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.User;
import org.api_builder.dao.ApiDao;
import org.api_builder.dao.impl.ApiDaoImpl;
import org.api_builder.services.ApiService;

public class ApiServiceImpl implements ApiService {
	
	private ApiDao dao;
	
	public ApiServiceImpl() {
		dao = new ApiDaoImpl();
	}
	
	@Override
	public Api getApi(User user, String name) {
		List<Api> apiList = getAllApiForUser(user);  
		for(Api api : apiList){
			if(api.getName().equals(name)){
				return api;
			}
		}
		return null;
	}

	@Override
	public Api getByName(String name, User user) {
		return dao.getByName(name, user);
	}

	@Override
	public List<Api> getAllApiForUser(User user) {
		return dao.getAllApiForUser(user);
	}

	@Override
	public List<Api> getAllApiForUserId(String userId) {
		return dao.getAllApiForUserId(userId);
	}

	@Override
	public Api saveApi(Api api) {
		return dao.add(api);
		
	}
}
