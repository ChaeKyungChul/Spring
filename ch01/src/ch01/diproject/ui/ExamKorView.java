package ch01.diproject.ui;

import ch01.diproject.entity.Exam;

public class ExamKorView implements ExamView {

	private Exam exam;
	
	@Override
	public void print() {
		System.out.printf("당신의 교과성적입니다. - 총점 %d, 평균 %f \n", exam.total(), exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
	
		this.exam = exam;
	}

}
