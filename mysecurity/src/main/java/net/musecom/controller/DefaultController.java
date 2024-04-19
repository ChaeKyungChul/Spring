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
	@GetMapping("/hello")  //�ּ�â�� hello �Է��ϸ��
	public String hello() {
		System.out.println("hello�� ����");
		return "Hello~ Welcome to Java World!! Have a Good Luck" ;
	}
	
	@ResponseBody
	@GetMapping(value="/bye", produces="text/html;charset=UTF-8")  //�ּ�â�� bye �Է��ϸ�� , �ѱ۸��ν��Ѿ���
	public String bye() {
		System.out.println("bye�� ����");
		return "���̻� ������ �����ϴ� . ���� �����ϼ���" ;
 }
}
