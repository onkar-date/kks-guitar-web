package com.springboot.guitar.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.guitar.student.exceptions.ResourceNotFoundException;
import com.springboot.guitar.student.models.Student;
import com.springboot.guitar.student.repository.StudentRepository;
import com.springboot.guitar.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
	}

	@Override
	public Student updateStudent(long id, Student student) {
		Student existingStudent = getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setBatch(student.getBatch());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setJoiningDate(student.getJoiningDate());
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(long id) {
		Student student = getStudentById(id);
		studentRepository.deleteById(student.getId());
		
	}

}
