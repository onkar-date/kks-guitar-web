package com.springboot.guitar.batch.service;

import java.util.List;

import com.springboot.guitar.batch.models.Batch;

public interface BatchService {
	
	List<Batch> getAllBatch();
	
	Batch getBatchById(long id);
	
	Batch createBatch(Batch batch);
	
	Batch updateBatch(Batch batch);
	
	String deleteBatch(long id);
	
	List<String> getBatchTypes();

}
