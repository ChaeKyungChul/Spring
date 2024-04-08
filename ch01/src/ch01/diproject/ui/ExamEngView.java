package ch01.diproject.ui;

import ch01.diproject.entity.Exam;

public class ExamEngView implements ExamView {

	private Exam exam;
	
	@Override
	public void print() {
		System.out.printf("Your course grades - total is %d, avg is %f\n", exam.total(), exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
