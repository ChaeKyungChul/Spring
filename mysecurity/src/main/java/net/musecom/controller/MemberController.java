package net.musecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	//로그인페이지
	@GetMapping("/home")
	public String home() {
		System.out.println("member/home 실행");
		return "home";
	}
	
	@GetMapping("/gallery")
	public String gallery() {
		System.out.println("member/gallery 실행");
		return "gallery";
	}
	
	@GetMapping("/bye")
	public String bye() {
		System.out.println("member/bye 실행");
		return "bye";
	}
}
