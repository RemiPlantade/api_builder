package org.api_builder.dao;

import java.util.List;

import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;

public interface ParameterDao {
	public Parameter add(Parameter param);
	public Parameter findById(int id);
	public List<Parameter> fromRequest(Request req);
}
