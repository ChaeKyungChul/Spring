package attendance.dto;


public class DBto {
   private int id;
   private String name;
   private String student_id;
   private String password;
   private String code;
   private String title;
   private String userPass;
   private String userId;
   private String subject;
   private double score;
   
   public DBto() {};
     

@Override
public String toString() {
	return "DBto [id=" + id + ", name=" + name + ", student_id=" + student_id + ", password=" + password + ", code="
			+ code + ", title=" + title + ", userPass=" + userPass + ", userId=" + userId + ", subject=" + subject
			+ ", score=" + score + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getStudent_id() {
	return student_id;
}

public void setStudent_id(String student_id) {
	this.student_id = student_id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getUserPass() {
	return userPass;
}

public void setUserPass(String userPass) {
	this.userPass = userPass;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public double getScore() {
	return score;
}

public void setScore(double score) {
	this.score = score;
}
   
}