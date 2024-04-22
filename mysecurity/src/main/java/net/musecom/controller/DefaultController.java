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
	@GetMapping("/hello")  //�ּ�â�� hello �Է��ϸ��
	public String hello() {
		System.out.println("hello�� ����");
		return "Hello~ Welcome to Java World!! Have a Good Luck" ;
	}
	
	
	@GetMapping("/clogin")  //Ŀ���ҷα���â
	public String customLogin() {
		return "login";
	}
	
	
	}

