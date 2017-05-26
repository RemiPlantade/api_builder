package org.api_builder.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.api_builder.beans.Api;
import org.api_builder.beans.DataSource;
import org.api_builder.beans.Method;
import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;
import org.api_builder.beans.SourceType;
import org.api_builder.beans.User;
import org.api_builder.hibernate.HiberUtil;
import org.api_builder.services.ApiService;
import org.api_builder.services.DataSourceService;
import org.api_builder.services.ParameterService;
import org.api_builder.services.RequestService;
import org.api_builder.services.SourceTypeService;
import org.api_builder.services.UserService;
import org.api_builder.services.impl.ApiServiceImpl;
import org.api_builder.services.impl.DataSourceServiceImpl;
import org.api_builder.services.impl.ParameterServiceImpl;
import org.api_builder.services.impl.RequestServiceImpl;
import org.api_builder.services.impl.SourceTypeServiceImpl;
import org.api_builder.services.impl.UserServiceImpl;

/**
 * Servlet implementation class Initialize
 */
@WebServlet("/init")
public class InitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userServ;
	private ApiService apiServ;
	private RequestService reqServ;
	private ParameterService paramServ;
	private DataSourceService dataServ;
	private SourceTypeService sourceServ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitController() {
        super();
        userServ = new UserServiceImpl();
        apiServ= new ApiServiceImpl();
        reqServ = new RequestServiceImpl();
        paramServ = new ParameterServiceImpl();
        dataServ = new DataSourceServiceImpl();
        sourceServ = new SourceTypeServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertSamples();
		this.getServletContext().getRequestDispatcher( "/WEB-INF/init.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void insertSamples(){
		User user = new User();
		user.setLogin("doremus");
		user.setPassword("pwd");
		user.setMail("d0r3mu5@gmail.com");
		user.setUserId("0001X");
		userServ.saveUser(user);

		
		SourceType srcType = new SourceType();
		srcType.setSgbdName("Mysql");
		srcType.setDriverClass("com.mysql.jdbc.Driver");
		sourceServ.saveSourceType(srcType);
		
		DataSource dataSource = new DataSource();
		dataSource.setName("api_builder");
		dataSource.setAddress("localhost");
		dataSource.setPort(3306);
		dataSource.setLogin("root");
		dataSource.setPwd("");
		dataSource.setSourceType(srcType);
		dataServ.saveDataSource(dataSource);
		
		Api api = new Api();
		api.setName("first");
		api.setOwner(user);
		api.setDataSource(dataSource);
		apiServ.saveApi(api);
		
		Parameter param1 = new Parameter();
		param1.setName("id");
		paramServ.saveParam(param1);
		
		Request req1 = new Request();
		req1.setParameters(new ArrayList<>(Arrays.asList(param1)));
		req1.setApi(api);
		req1.setMethod(Method.GET);
		req1.setUri("api");
		reqServ.saveRequest(req1);
		
		
		
	}

}
