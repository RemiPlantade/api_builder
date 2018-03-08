package api_builder.app.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.service.ApiConfService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ApiConfService apiService;

	@Value("${server.ssl.enabled}")
	private String requireSSL;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//		if (securityProperties.isRequireSsl()) http.requiresChannel().anyRequest().requiresSecure();
		if (requireSSL.equals("true")) { 
			http.requiresChannel().anyRequest().requiresSecure();
		}

		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.NEVER);

		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/js/**").permitAll()
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
		ApiConf adminUserNameConf = apiService.findByParamKey("api.admin.username");
		ApiConf adminPasswordConf = apiService.findByParamKey("api.admin.password");

		String adminUsername = 
				adminUserNameConf.getParamValue() != null 
				&& !adminUserNameConf.getParamValue().equals("") ? 
						adminUserNameConf.getParamValue() : "admin";
						String adminPassword = 
								adminPasswordConf.getParamValue() != null 
								&& !adminPasswordConf.getParamValue().equals("") ? 
										adminPasswordConf.getParamValue() : "admin";

										auth.inMemoryAuthentication().withUser(adminUsername).password(adminPassword).roles("ADMIN");
	}
}
