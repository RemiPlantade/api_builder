package org.api_builder.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.api_builder.beans.Api;
import org.api_builder.beans.Request;
import org.api_builder.misc.UriTools;
import org.api_builder.services.RequestService;
import org.api_builder.services.impl.RequestServiceImpl;

public class RequestFilter implements Filter {
	private RequestService reqServ;
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		reqServ = new RequestServiceImpl();
		context = filterConfig.getServletContext();
		context.log("=============== Request filter loaded");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String uri = ((HttpServletRequest)request).getRequestURI().toString();
			Api api = (Api) context.getAttribute("api");
			context.log("=============== Get api :" + api);
			String reqName = UriTools.getRequestFromURI(uri);
			context.log("=============== Request name :" + api);
			Request req = reqServ.getRequestByUriAndApi(reqName, api);
			if(req != null){
				context.log("=============== Set Request :" + req);
				context.setAttribute("apiRequest", req);
				chain.doFilter(request, response);
			}
		}

	}

}
