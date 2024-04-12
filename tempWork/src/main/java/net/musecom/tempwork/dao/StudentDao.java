package net.musecom.tempwork.dao;

import java.util.List;

import net.musecom.tempwork.model.StudentDto;

public interface StudentDao {
    
	public int create(StudentDto dto);
	
	public int update(StudentDto dto);
	
	public int delete(int studentId);
	
	public List<StudentDto> read();
	
	public List<StudentDto> findStudentById(int studentId);
}
