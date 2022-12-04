package com.springboot.guitar.student.service;

import java.util.List;

import com.springboot.guitar.student.models.Student;


public interface StudentService {

	Student saveStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudentById(long id);
	
	Student updateStudent(long id, Student student);
	
	void deleteStudent(long id);
}
