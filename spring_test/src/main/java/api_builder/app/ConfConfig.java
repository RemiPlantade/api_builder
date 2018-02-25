package api_builder.app;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "confEntityManager", 
		transactionManagerRef = "tm2",
		basePackages = { "api_builder.app.conf.dao" })
public class ConfConfig {
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
				.persistenceUnit("conf")
				.build();

		emf.setJpaProperties(properties);

		return emf;
	}



	@Bean(name="tm2")
	@Autowired
	public PlatformTransactionManager transactionManager(@Qualifier("confEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
