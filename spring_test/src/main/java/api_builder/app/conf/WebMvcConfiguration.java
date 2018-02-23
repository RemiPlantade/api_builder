package api_builder.app.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@EnableWebMvc
@ComponentScan("api_builer.conf.controller")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("/login");
//		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//
//	}


	@Bean 
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/resources");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(0);
		resolver.setCacheable(false);
		return resolver;
	}

	@Bean 
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine  =  new SpringTemplateEngine();
		engine.addDialect(new SpringSecurityDialect());
		engine.setTemplateResolver( templateResolver() );
		return engine;
	}

	@Bean 
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver  =  new ThymeleafViewResolver();
		resolver.setTemplateEngine( templateEngine() );
		resolver.setOrder(1);

		resolver.setCache( false );
		return resolver;
	}

	@Bean
	public SpringResourceTemplateResolver thymeleafSpringResource() {
		SpringResourceTemplateResolver vista = new SpringResourceTemplateResolver();
		vista.setTemplateMode("HTML5");
		return vista;
	}


}
