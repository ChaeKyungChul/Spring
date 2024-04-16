package net.musecom.tempwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.musecom.tempwork.dao.StudentDao;
import net.musecom.tempwork.model.StudentDto;

@Service
public class StudentService {
   
	@Autowired
	private StudentDao studentDao;
	
	//create
	@Transactional
	public int addStudent(StudentDto dto) {
		return studentDao.create(dto);
	}
	//update
	@Transactional
	public int updateStudent(StudentDto dto) {
		return studentDao.update(dto);
	}
	//dalete
	@Transactional
	public int deleteStudent(int studentId) {
		return studentDao.delete(studentId);
	}
	
	//read
	public List<StudentDto> getAllStudents(){
		return studentDao.read();
	}
	
	//findeById
	public StudentDto getStudentById(int studentId) {
		return studentDao.findStudentById(studentId);
	}
}
