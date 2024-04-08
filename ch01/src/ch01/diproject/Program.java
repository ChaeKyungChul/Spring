package ch01.diproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch01.diproject.entity.Exam;
import ch01.diproject.ui.ExamView;

public class Program {

	public static void main(String[] args) {
		
		/*
		 스프링 지시서(xml)에 담을예정
		Exam exam = new MyLecExam();
		ExamView view = new ExamEngView(); //DI
		//ExamView view = new ExamKorView(exam); //DI
		view.setExam(exam);
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("ch01/diproject/setting.xml");
		
		//ExamView view = (ExamView) context.betBean("view");
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		ExamView view = context.getBean(ExamView.class);
		
		
		
		view.print();
	}

}
