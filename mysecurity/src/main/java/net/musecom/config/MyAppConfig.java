package net.musecom.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("net")
public class MyAppConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	//db���� DataSource
	@Bean
	DataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("dufrhdgkwk10@");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return driverManagerDataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}
	
		
}
