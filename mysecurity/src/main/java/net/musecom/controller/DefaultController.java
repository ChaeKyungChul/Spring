package net.musecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
	
	@GetMapping("/")
	public String index() {
		return "default";
	}
	
	@ResponseBody
	@GetMapping("/hello")  //주소창에 hello 입력하면뜸
	public String hello() {
		System.out.println("hello가 실행");
		return "Hello~ Welcome to Java World!! Have a Good Luck" ;
	}
	
	
	@GetMapping("/clogin")  //커스텀로그인창
	public String customLogin() {
		return "login";
	}
	
	
	}

