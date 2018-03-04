package api_builder.app;

import java.util.Properties;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
@Component
public class CustomInitializer implements ApplicationContextInitializer {
	
	
	  @Override
	  public void initialize(final ConfigurableApplicationContext context) {
	    ConfigurableEnvironment environment = context.getEnvironment();

	    MutablePropertySources propertySources = environment.getPropertySources();

	    Properties props = loadPropertiesFromDatabase();
	    PropertiesPropertySource propertySource = new PropertiesPropertySource("myProps", props);
	    propertySources.addFirst(propertySource);
	  }
	  
	  private Properties loadPropertiesFromDatabase() {
			Properties props = new Properties();
			props.setProperty("foo", "baboo");
			return new Properties();
		}

}
