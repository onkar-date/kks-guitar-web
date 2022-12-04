package com.springboot.guitar.testimonial.controller;

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

import com.springboot.guitar.testimonial.models.Testimonial;
import com.springboot.guitar.testimonial.service.TestimonialService;

@RestController
@RequestMapping(value = "/api/testimonial")
@CrossOrigin(origins = "http://localhost:3000")
public class TestimonialController {
	
	private TestimonialService testimonialService;
	
	public TestimonialController(TestimonialService testimonialService) {
		this.testimonialService = testimonialService;
	}
	
	@GetMapping
	public ResponseEntity<List<Testimonial>> getAllTestimonials() {
		return new ResponseEntity<List<Testimonial>>(testimonialService.getAllTestimonials(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Testimonial> getTestimonialById(@PathVariable("id") long id) {
		return new ResponseEntity<Testimonial>(testimonialService.getTestimonialById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Testimonial> addTestimonial(@RequestBody Testimonial testimonial) {
		return new ResponseEntity<Testimonial>(testimonialService.addTestimonial(testimonial), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Testimonial> updateTestimonial(@RequestBody Testimonial testimonial) {
		return new ResponseEntity<Testimonial>(testimonialService.updateTestimonial(testimonial), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteTestimonial(@RequestParam long id) {
		return new ResponseEntity<String>(testimonialService.deleteTestimonial(id), HttpStatus.OK);
	}

}
