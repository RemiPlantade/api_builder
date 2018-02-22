package api_builder.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Yolo ma couille !!!!!!!!!!!!!!!!!!!!!");
		 http
         .authorizeRequests()
             //.antMatchers("/resources/**").permitAll()
             .antMatchers("/resources/admin/**").hasRole("ADMIN")
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login").failureUrl("/unauth")
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
