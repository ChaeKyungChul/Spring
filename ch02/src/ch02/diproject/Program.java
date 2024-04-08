package ch02.diproject;

import ch02.diproject.entity.Exam;
import ch02.diproject.entity.MyLecExam;
import ch02.diproject.ui.ExamEngview;
import ch02.diproject.ui.ExamKorView;
import ch02.diproject.ui.ExamView;


public class Program {

	public static void main(String[] args) {
		
		Exam exam = new MyLecExam();
		//ExamView view = new ExamEngview();
		ExamView view = new ExamKorView();
		view.setExam(exam);
		view.print();
		
				
	}

}
