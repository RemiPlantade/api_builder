package api_builder.app;

import java.util.Properties;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
public class CustomListener implements ApplicationListener<ApplicationPreparedEvent > {
//
//	@Override
//	public void initialize(ConfigurableApplicationContext context) {
//		ConfigurableEnvironment environment = context.getEnvironment();
//
//	    MutablePropertySources propertySources = environment.getPropertySources();
//
//	    Properties props = loadPropertiesFromDatabase();
//	    PropertiesPropertySource propertySource = new PropertiesPropertySource("myProps", props);
//	    propertySources.addFirst(propertySource);
//		
//	}

	private Properties loadPropertiesFromDatabase() {
		Properties props = new Properties();
		props.setProperty("foo", "baboo");
		return new Properties();
	}
	
	

//	@Override
//	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent arg0) {
//		ConfigurableEnvironment environment = arg0.getEnvironment();
//
//	    MutablePropertySources propertySources = environment.getPropertySources();
//
//	    Properties props = loadPropertiesFromDatabase();
//	    PropertiesPropertySource propertySource = new PropertiesPropertySource("myProps", props);
//	    propertySources.addFirst(propertySource);
//		
//	}

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent arg0) {
		ConfigurableEnvironment environment = arg0.getApplicationContext().getEnvironment();

	    MutablePropertySources propertySources = environment.getPropertySources();

	    Properties props = loadPropertiesFromDatabase();
	    PropertiesPropertySource propertySource = new PropertiesPropertySource("myProps", props);
	    propertySources.addFirst(propertySource);
		
	}
	
	

}
