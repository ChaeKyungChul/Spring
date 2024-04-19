package net.musecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@ResponseBody
	@GetMapping(value="/bye", produces="text/html;charset=UTF-8")  //주소창에 bye 입력하면뜸 , 한글메핑시켜야함
	public String bye() {
		System.out.println("bye가 실행");
		return "더이상 배울것이 없습니다 . 이제 졸업하세요" ;
 }
}
