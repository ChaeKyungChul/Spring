package ch02.diproject.entity;

import ch02.diproject.ui.Exammath;

public class MyLecExam implements Exam {


	private int math;
	private int com;
	
	@Override
	public int total() {
		return math + com;
	}

	@Override
	public float avg() {
		return total() / 2.0f;
	}

}
