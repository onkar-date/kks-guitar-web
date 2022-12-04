package com.springboot.guitar.student.models;

import com.springboot.guitar.batch.models.Batch;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "batch", nullable = false)
	private Batch batch;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "joining_date", nullable = false)
	private String joiningDate;

}
