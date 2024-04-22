package net.musecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //auth을받아서 
	
		auth
		    .inMemoryAuthentication()
		    .withUser("wein")
		    .password("$2a$10$o6ysXkhAlnwavhUVREs3sOeGGviamBCuRm5wEBlmGT8nNLlk.NN3W")
		    .roles("ADMIN");
		
	       	System.out.println("my password id crypt " + bcryptPasswordEncoder.encode("1234")); //bcrypt 알고리즘암호화
		    /*
		    .and()
		    .withUser("wein")
		    .password("1234")
		    .roles("USER");
		    */
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		    .authorizeRequests() //승인요청 . anyRequest() 모든요청
		    /*
		    .antMatchers("/").permitAll() // 진입페이지는 공개
		    .antMatchers("/hello").permitAll()
		    .antMatchers("/bye").permitAll()
		    */
		    .antMatchers("/member/**").authenticated()  //member  폴더는 인증	
		     .anyRequest().permitAll()
		     .and()
		     .formLogin().loginPage("/clogin").loginProcessingUrl("/member/gallery")
		     .and() 
		     .httpBasic()
		     .and()
		     .logout(); 
		//	.logoutUrl("/member/bye") //로그아웃을 수행할 URL을 지정할때 사용
		  //.logoutSuccessUrl("/bye?logout") //로그아웃 성공 하면 리다이렉션되는 URL
		 // .deleteCookies("JSESSIONID")  //삭제할 쿠키이름
		 // .invalidateHttpSession(true); // 기존 세션 무효화
			
		
		
		       
	       
	}  
}
