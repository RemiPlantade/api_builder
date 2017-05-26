package org.api_builder.services;

import java.util.List;

import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;

public interface ParameterService {
	public Parameter saveParam(Parameter param);
	public Parameter findParamById(int id);
	public List<Parameter> getParamsFromRequest(Request req);
}
