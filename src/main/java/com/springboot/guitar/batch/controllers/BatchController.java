package com.springboot.guitar.batch.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.guitar.batch.models.Batch;
import com.springboot.guitar.batch.service.BatchService;

@RestController
@RequestMapping(value = "/api/batch")
@CrossOrigin(origins = "http://localhost:3000")
public class BatchController {
	
	private BatchService batchService;
	
	public BatchController(BatchService batchService) {
		this.batchService = batchService;
	}
	
	@PostMapping
	public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
		System.out.println(batch);
		return new ResponseEntity<Batch>(batchService.createBatch(batch), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Batch> getAllBatches() {
		return batchService.getAllBatch();
	}
	
	@GetMapping(value = "/batchTypes")
	public List<String> getBatchTypes() {
		return batchService.getBatchTypes();
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteBatch(@RequestParam long batchId) {
		return new ResponseEntity<String>(batchService.deleteBatch(batchId), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch) {
		return new ResponseEntity<Batch>(batchService.updateBatch(batch), HttpStatus.OK); 
	}

}
