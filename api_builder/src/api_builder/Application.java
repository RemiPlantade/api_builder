package api_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import api_builder.jackson.CustomBeanSerializerModifier;

import api_builder.controller.ConducteurController;


@PropertySource({"classpath:application.properties"})
@SpringBootApplication
@ComponentScan(basePackages = "api_builder") 
public class Application {

	private static Log logger = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		logger.info("======================== start");
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@Primary
	public static ObjectMapper objectMapper() {
		return new ObjectMapper()
			    .registerModule(new SimpleModule()
			            .setSerializerModifier(new CustomBeanSerializerModifier()));
	}
}