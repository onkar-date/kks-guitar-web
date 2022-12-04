package com.springboot.guitar.batch.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "batches")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "batch_name", nullable = false)
	private String batchName;
	
	@Column(name = "start_time", nullable = false)
	private String startTime;
	
	@Column(name = "end_time", nullable = false)
	private String endTime;
	
	@Column(name = "batch_type", nullable = false)
	private String batchType;
	
}
