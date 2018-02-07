package api_builder.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.PropertySource;


import api_builder.gen.jackson.CustomBeanSerializerModifier;
@PropertySource({"classpath:application.properties"})
@SpringBootApplication
@Configuration
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
}