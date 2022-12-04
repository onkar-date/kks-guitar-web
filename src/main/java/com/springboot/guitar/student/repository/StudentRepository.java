package com.springboot.guitar.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.guitar.student.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}