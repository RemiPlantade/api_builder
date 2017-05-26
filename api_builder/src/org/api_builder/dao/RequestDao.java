package org.api_builder.dao;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.Request;

public interface RequestDao {
	public Request add(Request req);
	public Request findById(int id);
	public List<Request> getAllFromAPI(Api api);
}
