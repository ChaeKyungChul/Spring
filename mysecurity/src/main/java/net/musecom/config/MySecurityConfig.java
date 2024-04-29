package net.musecom.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		auth
		   .inMemoryAuthentication()
		   .withUser("wein")
		   .password("$2a$10$pm18n5NEWKEGHParGh99veuAiF4iO2BeZeMupIipyrMXaWfv5CP66")
		   .roles("ADMIN");
         */
		
		 auth
		   .jdbcAuthentication()
		   .dataSource(dataSource)
		   .passwordEncoder(bcryptPasswordEncoder);
		
	        //System.out.println("my password id crypt " + bcryptPasswordEncoder.encode("1234"));
	
	}
	
   @Override
   protected void configure(HttpSecurity http) throws Exception {

	   http 
	     .authorizeRequests()   
	     /*
	     .antMatchers("/").permitAll()   
	     .antMatchers("/hello").permitAll()
	     .antMatchers("/bye").permitAll()
	     */ 
	     .antMatchers("/member/**").authenticated()  
	     .anyRequest().permitAll()
	     .and()
	     .formLogin().loginPage("/clogin").loginProcessingUrl("/")
	     .and()
	     .logout().logoutUrl("/logout")
	              .logoutSuccessUrl("/")
	              .invalidateHttpSession(true)  //세션 무효화 (자동으로 된다)
	              .deleteCookies("JSESSIONID")  //쿠키 삭제 (자동으로 된다)
	     .and() 
	     .httpBasic(); 
   }
	
}
