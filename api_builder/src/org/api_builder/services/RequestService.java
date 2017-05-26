package org.api_builder.services;

import java.util.List;

import org.api_builder.beans.Api;
import org.api_builder.beans.Request;

public interface RequestService {
	public Request saveRequest(Request req);
	public Request getRequestById(int id);
	public Request getRequestByUriAndApi(String name, Api api);
	public List<Request> getAllRequestFromAPI(Api api);
}
