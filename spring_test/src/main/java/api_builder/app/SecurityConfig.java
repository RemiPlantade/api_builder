package api_builder.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/css/**", "/index").permitAll()		
//				.antMatchers("/admin/**").hasRole("ADMIN")			
//				.and()
//			.formLogin()
//				.loginPage("/login").failureUrl("/login-error");	
		 http
         .authorizeRequests()
             .antMatchers("/resources/**").permitAll()
             //.antMatchers("/admin/**").hasRole("ADMIN")
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login").failureUrl("/login-error")
             .permitAll()
             .and()
         .logout()                                    
             .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
	}
}
