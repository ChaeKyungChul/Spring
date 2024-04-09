package net.musecom.spbbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		System.out.println("index controller에서 dispatcher-servlet의 id값 도메인을 index.jsp로 보냄");
		ModelAndView mv = new ModelAndView();
		mv.addObject("date", "Hello Spring MVC");
		mv.setViewName("/WEB-INF/view/index.jsp");
				
		return mv;
	}

}
