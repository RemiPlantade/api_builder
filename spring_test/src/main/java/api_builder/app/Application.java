package api_builder.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import api_builder.app.gen.jackson.CustomBeanSerializerModifier;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@PropertySource({"classpath:application.properties"})
@Configuration
@ComponentScan
@EnableAutoConfiguration 
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
        .listeners(new CustomListener())
        .initializers(new CustomInitializer())
        .run(args);
//		SpringApplication.run(Application.class, args);

	}

	@Bean
	@Primary
	ObjectMapper objectMapper() {
		return new ObjectMapper()
				.registerModule(new SimpleModule()
						.setSerializerModifier(new CustomBeanSerializerModifier()));
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}
