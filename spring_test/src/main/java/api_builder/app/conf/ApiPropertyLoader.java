package api_builder.app.conf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

public class ApiPropertyLoader {
	
	public static ApiPropertyLoader instance;
	
	private final String URL = "jdbc:sqlite:src/main/resources/test.db";
	private final String DRIVER = "org.sqlite.JDBC";
	
	private ApiPropertyLoader() {
		 
		 
	}

	public static ApiPropertyLoader getInstance() {
		if(instance == null) {
			instance = new ApiPropertyLoader();
		}
		return instance;
	}
	
	public Properties getAllPropertiesFromDatabase() throws SQLException {
		Properties props = new Properties();
		DataSource ds = DataSourceBuilder
                .create()
                .url(URL)
                .driverClassName(DRIVER)
                .build();
		Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM api_conf ORDER BY param_name ASC");
        ResultSet rs = preparedStatement.executeQuery();

        // Populate all properties into the property source
        while (rs.next()) {
        	props.put(rs.getString("param_key"), rs.getString("param_value"));
        }
        return props;

	}
}
