package com.springboot.guitar.testimonial.service;

import java.util.List;

import com.springboot.guitar.testimonial.models.Testimonial;

public interface TestimonialService {
	
	List<Testimonial> getAllTestimonials();
	
	Testimonial getTestimonialById(long id);
	
	Testimonial addTestimonial(Testimonial testimonial);
	
	Testimonial updateTestimonial(Testimonial testimonial);
	
	String deleteTestimonial(long id);

}
