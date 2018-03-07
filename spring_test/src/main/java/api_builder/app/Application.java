package api_builder.app;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import api_builder.app.conf.ApiPropertyLoader;
import api_builder.app.gen.jackson.CustomBeanSerializerModifier;
import nz.net.ultraq.thymeleaf.LayoutDialect;

//@PropertySource({"classpath:application.properties"})
@Configuration
@ComponentScan
@EnableAutoConfiguration 
@EnableTransactionManagement
@SpringBootApplication
public class Application {

	@Value("${security.require-ssl}")
	private String requireSSL;

	@Value("${server.port}")
	private String actualServerPort;

	@Value("${previous.api.port}")
	private String previousServerPort;


	public static void main(String[] args) {
		//		new SpringApplicationBuilder(Application.class)
		//        .listeners(new CustomListener())
		//        .initializers(new CustomInitializer())
		//        .run(args);
		SpringApplication.run(Application.class, args);

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

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException, SQLException {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setIgnoreUnresolvablePlaceholders(Boolean.TRUE);

		// create a custom property source and apply into pspc
		MutablePropertySources propertySources = new MutablePropertySources();
		ApiPropertyLoader propLoader = ApiPropertyLoader.getInstance();

		final PropertiesPropertySource propertySource = new PropertiesPropertySource("pspc", propLoader.getAllPropertiesFromDatabase());
		propertySources.addFirst(propertySource);
		pspc.setPropertySources(propertySources);

		//pspc.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:application.properties"));
		return pspc;
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				if(!actualServerPort.equals(previousServerPort)) {
//					System.out.println(">>>>>> Previous server Port : " + previousServerPort);
//					registry.addMapping("/").allowedOrigins("http://localhost:" + previousServerPort,"https://localhost:" + previousServerPort);
//				}
//			}
//		};
//	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				if(requireSSL.equals("true")) {
					System.out.println(">>>>> HTTPS Enabled");
					SecurityConstraint securityConstraint = new SecurityConstraint();
					securityConstraint.setUserConstraint("CONFIDENTIAL");
					SecurityCollection collection = new SecurityCollection();
					collection.addPattern("/*");
					securityConstraint.addCollection(collection);
					context.addConstraint(securityConstraint);
				}else {
					System.out.println(">>>>> HTTPS not enabled");
				}
			}

		};
		if(requireSSL.equals("true")) {
			tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		}
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);

		return connector;
	}

}
