package api_builder.app.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.service.ApiConfService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ApiConfService apiService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/actuator/**").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login-error")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.permitAll();
		
		http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/restart/**").hasRole("ADMIN");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		ApiConf adminUserNameConf = apiService.findByParamName("Admin username");
		ApiConf adminPasswordConf = apiService.findByParamName("Admin password");

		String adminUsername = 
				adminUserNameConf.getParamValue() != null 
				&& !adminUserNameConf.getParamValue().equals("") ? 
						adminUserNameConf.getParamValue() : "admin";
						String adminPassword = 
								adminPasswordConf.getParamValue() != null 
								&& !adminPasswordConf.getParamValue().equals("") ? 
										adminPasswordConf.getParamValue() : "defaultPassword";

										auth.inMemoryAuthentication().withUser(adminUsername).password(adminPassword).roles("ADMIN");
	}
}
