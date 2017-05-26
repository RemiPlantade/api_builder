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
import javax.servlet.http.HttpSession;

import org.api_builder.beans.User;
import org.api_builder.hibernate.HiberUtil;
import org.api_builder.misc.UriTools;
import org.api_builder.services.UserService;
import org.api_builder.services.impl.UserServiceImpl;
import org.jboss.logging.Logger;

public class UserFilter implements Filter {
	private static Logger logger = Logger.getLogger(UserFilter.class);
	private UserService userServ;
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userServ = new UserServiceImpl();
		context = filterConfig.getServletContext();
		context.log("=============== User filter loaded");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String uri = ((HttpServletRequest)request).getRequestURI().toString();
			String userId = UriTools.getUserIdFromURI(uri);
			if(userId != null && !userId.equals("")){
				User user = userServ.getUserByUserId(userId);
				if(user != null){
					context.log("=============== Set User : " + user);
					context.setAttribute("owner", user);
					chain.doFilter(request, response);
				}
			}
		}

	}

}
