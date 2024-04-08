package ch02.diproject.ui;

import ch02.diproject.entity.Exam;

public class ExamKorView implements ExamView {
	
	private Exam exam;

	@Override
	public void print() {
		System.out.printf("����Ǽ����� ����:%d , ���: %f\n", exam.total() , exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		
		this.exam = exam;
		
	}

}