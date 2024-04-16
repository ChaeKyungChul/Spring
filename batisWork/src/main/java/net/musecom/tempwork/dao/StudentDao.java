package net.musecom.tempwork.dao;

import java.util.List;

import net.musecom.tempwork.model.StudentDto;

public interface StudentDao {
    
	 int create(StudentDto dto);
	
	 int update(StudentDto dto);
	
	 int delete(int studentId);
	
	 List<StudentDto> read();
	
	 StudentDto findStudentById(int studentId);
}
