package org.api_builder.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.api_builder.beans.Api;
import org.api_builder.beans.Parameter;
import org.api_builder.beans.Request;
import org.api_builder.beans.User;
import org.api_builder.driver.ConnexionFactory;
import org.jboss.logging.Logger;
@WebServlet("/api/*")
public class MainController extends HttpServlet {
	private static Logger logger = Logger.getLogger(MainController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User owner = (User) getServletContext().getAttribute("owner");
		Api api = (Api) getServletContext().getAttribute("api");
		Request apiReq = (Request) getServletContext().getAttribute("apiRequest");
		Map<Parameter,String[]> apiParams = (Map<Parameter,String[]>) getServletContext().getAttribute("apiParams");

		logger.info("Owner : " + owner + " api : " + api  + " request : " + apiReq + " \n" 
		+ "Param : " + apiParams + " \n"
		+ "Api DataSource : " + api.getDataSource());
		
		Connection conn = ConnexionFactory.getConnectionFromDataSource(api.getDataSource());
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO user (login,password,mail,userid) VALUES('nahed','sheitan','bismil@coumshouf.arbica','007JamesBond')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

	}

}
