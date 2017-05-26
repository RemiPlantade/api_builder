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
import org.api_builder.beans.User;
import org.api_builder.misc.UriTools;
import org.api_builder.services.ApiService;
import org.api_builder.services.impl.ApiServiceImpl;

public class ApiFilter implements Filter {
	private ApiService apiServ;
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		apiServ = new ApiServiceImpl();
		context = filterConfig.getServletContext();
		context.log("=============== API filter loaded");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String uri = ((HttpServletRequest)request).getRequestURI().toString();
			User owner = (User) context.getAttribute("owner");
			context.log("=============== Get User : " + owner);
			String apiName = UriTools.getApiNameFromURI(uri);
			context.log("=============== Api name : " + apiName);
			Api api = apiServ.getApi(owner,apiName);
			if(api != null){
				context.log("=============== Set Api : " + api);
				context.setAttribute("api", api);
				chain.doFilter(request, response);
			}
		}
	}

}
