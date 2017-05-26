package org.api_builder.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;
import org.api_builder.services.ParameterService;
import org.api_builder.services.impl.ParameterServiceImpl;

public class ParameterFilter implements Filter {
	private ParameterService paramServ;
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		paramServ = new ParameterServiceImpl();
		context = filterConfig.getServletContext();
		context.log("=============== Parameter Filter laoaded");
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String uri = ((HttpServletRequest)request).getRequestURI().toString();
			Request apiReq = (Request) context.getAttribute("apiRequest");
			context.log("=============== Get Request : " + apiReq);
			List<Parameter> allowedParams = paramServ.getParamsFromRequest(apiReq);
			context.log("=============== Allowed Params : " + allowedParams);
			Map<String, String[]> sendParams = request.getParameterMap();
			Map<Parameter,String[]> effectiveParams = new HashMap<>();
			for (Entry<String, String[]> param : sendParams.entrySet()) {
				boolean match = false;
				for (Parameter parameter : allowedParams) {
					if(parameter.getName().equals(param.getKey())){
						effectiveParams.put(parameter,param.getValue());
						match = true;
					}
				}
				if(!match){
					throw new RuntimeException("Parameter not allowed : " + param.getKey());
				}
			}
			context.log("=============== Set Parameter : " + effectiveParams);
			context.setAttribute("apiParams", effectiveParams);
			chain.doFilter(request, response);
		}

	}

}
