package com.springboot.guitar.batch.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.guitar.batch.models.Batch;
import com.springboot.guitar.batch.repository.BatchRepository;
import com.springboot.guitar.batch.service.BatchService;
import com.springboot.guitar.batch.utils.BatchConstants;
import com.springboot.guitar.student.exceptions.ResourceNotFoundException;

@Service
public class BatchServiceImpl implements BatchService {
	
	private BatchRepository batchRepository;
	
	public BatchServiceImpl(BatchRepository batchRepository) {
		this.batchRepository = batchRepository;
	}

	@Override
	public List<Batch> getAllBatch() {
		return batchRepository.findAll();
	}

	@Override
	public Batch getBatchById(long id) {
		return batchRepository.findById(id).orElseThrow(() -> {
			return new ResourceNotFoundException("Batch", "ID", id);
		});
	}

	@Override
	public Batch createBatch(Batch batch) {
		return batchRepository.save(batch);
	}

	@Override
	public Batch updateBatch(Batch batch) {
		Batch existingBatch = getBatchById(batch.getId());
		existingBatch.setBatchName(batch.getBatchName());
		existingBatch.setBatchType(batch.getBatchType());
		existingBatch.setEndTime(batch.getEndTime());
		existingBatch.setStartTime(batch.getStartTime());
		batchRepository.save(existingBatch);
		return existingBatch;
	}

	@Override
	public String deleteBatch(long id) {
		batchRepository.deleteById(id);
		return "Batch Deleted Successfully";
	}

	@Override
	public List<String> getBatchTypes() {
		List<String> batchTypes = new ArrayList<String>();
		batchTypes.add(BatchConstants.MORNING_BATCH);
		batchTypes.add(BatchConstants.AFTERNOON_BATCH);
		batchTypes.add(BatchConstants.EVENING_BATCH);
		return batchTypes;
	}

}
