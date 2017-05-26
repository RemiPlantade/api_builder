package org.api_builder.services;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.User;

public interface ApiService {
	public Api getByName(String name,User user);
	public List<Api> getAllApiForUser(User user);
	public List<Api> getAllApiForUserId(String userId);
	public Api getApi(User user, String name);
	public Api saveApi(Api api);
}
