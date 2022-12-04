package com.springboot.guitar.student.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.guitar.student.models.Student;
import com.springboot.guitar.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student.getId(), student), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/id")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteStudentById(@RequestParam long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
