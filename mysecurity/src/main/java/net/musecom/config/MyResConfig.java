package net.musecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyResConfig implements WebMvcConfigurer {
   
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //res 요청이 오면  public 폴더나 classpath:/static/ 경로 아래에 있는 파일들을 찾는다.
		registry.addResourceHandler("/res/**").addResourceLocations("/public/", "classpath:/static/");
	
	}
}
