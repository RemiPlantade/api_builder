package api_builder.app;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import api_builder.app.gen.jackson.CustomBeanSerializerModifier;

@PropertySource({"classpath:application.properties"})
@Configuration
@ComponentScan(basePackages= {"api_builder.app.gen","api_builder.app.conf"})
@EntityScan(basePackages= {"api_builder.app.gen.model","api_builder.app.conf.model"})
@EnableAutoConfiguration 
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Primary
	ObjectMapper objectMapper() {
		return new ObjectMapper()
				.registerModule(new SimpleModule()
						.setSerializerModifier(new CustomBeanSerializerModifier()));
	}
	
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
				.packages("api_builder.app.gen")
				.persistenceUnit("primaryPU")
				.build();

		emf.setJpaProperties(properties);

		return emf;
	}

	@Bean(name = "confDatabase")
	@ConfigurationProperties(prefix = "spring.conf")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "confEntityManager")
	public LocalContainerEntityManagerFactoryBean confStoringEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("confDatabase") DataSource ds) {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");

		LocalContainerEntityManagerFactoryBean emf = builder
				.dataSource(ds)
				.packages("api_builder.app.conf")
				.persistenceUnit("secondaryPU")
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

	@Bean(name="tm2")
	@Autowired
	DataSourceTransactionManager tm2(@Qualifier ("confDatabase") DataSource datasource) {
	    DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
	    return txm;
	}
}
