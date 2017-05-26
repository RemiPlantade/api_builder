package org.api_builder.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.api_builder.beans.DataSource;

public class ConnexionFactory {

	public static Connection getConnectionFromDataSource(DataSource dataSrc){
		Connection conn = null;
		try {
			Class.forName(dataSrc.getSourceType().getDriverClass());
		
			conn = DriverManager.getConnection(getUrlFromDataSource(dataSrc),dataSrc.getLogin(),dataSrc.getPwd());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	private static String getUrlFromDataSource(DataSource dataSrc){
		String url = "jdbc:mysql://" + dataSrc.getAddress() + ":" + dataSrc.getPort() 
		+ "/" + dataSrc.getName();
		return url;
	}
}
