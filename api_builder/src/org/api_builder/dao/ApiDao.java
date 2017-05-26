package org.api_builder.dao;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.User;

public interface ApiDao {
		public Api add(Api api);
		public Api getByName(String name, User user);
		public List<Api> getAllApiForUser(User user);
		public List<Api> getAllApiForUserId(String userId);
}
