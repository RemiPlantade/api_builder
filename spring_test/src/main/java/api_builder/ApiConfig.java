package api_builder;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(
        entityManagerFactoryRef = "apiEntityManager", 
        transactionManagerRef = "tm1",
        basePackages = { "api_builder.gen.dao" })
public class ApiConfig {
	
	@Primary
	@Bean(name = "apiDatabase")
	@ConfigurationProperties(prefix = "spring.api")
	public DataSource apiDataSource() {
		return  DataSourceBuilder.create().build();
	}
	@Primary
	@Bean(name = "apiEntityManager")
	public LocalContainerEntityManagerFactoryBean apiStoringEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("apiDatabase") DataSource ds) {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		LocalContainerEntityManagerFactoryBean emf = builder
				.dataSource(ds)
				.packages("api_builder.gen")
				.persistenceUnit("api")
				.build();

		emf.setJpaProperties(properties);

		return emf;
	}
	
	@Bean(name="tm1")
	@Autowired
	@Primary 
	DataSourceTransactionManager tm1(@Qualifier ("apiDatabase") DataSource datasource) {
		DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
		return txm;
	}

}
