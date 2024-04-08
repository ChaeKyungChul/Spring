package ch01.diproject.entity;

public class MyLecExam implements Exam {
	
	private int kor;
	private int eng;
	private int math;
	private int his;
	private int com;
	
	
	public MyLecExam() {
		
	}
	

	public MyLecExam(int kor, int eng, int math, int his, int com) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.his = his;
		this.com = com;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getHis() {
		return his;
	}

	public void setHis(int his) {
		this.his = his;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return kor + eng + math + his + com;
	}

	@Override
	public float avg() {
		return total() / 5.0f;
	}


	@Override
	public String toString() {
		return "MyLecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", his=" + his + ", com=" + com + "]";
	}

}
