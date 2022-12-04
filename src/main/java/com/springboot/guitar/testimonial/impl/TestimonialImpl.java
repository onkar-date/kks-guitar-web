package com.springboot.guitar.testimonial.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.guitar.testimonial.models.Testimonial;
import com.springboot.guitar.testimonial.repository.TestimonialRepository;
import com.springboot.guitar.testimonial.service.TestimonialService;
import com.springboot.guitar.batch.exceptions.ResourceNotFoundException;

@Service
public class TestimonialImpl implements TestimonialService {
	
	private TestimonialRepository testimonialRepository;
	public TestimonialImpl(TestimonialRepository testimonialRepository) {
		this.testimonialRepository = testimonialRepository;
	}

	@Override
	public List<Testimonial> getAllTestimonials() {
		return testimonialRepository.findAll();
	}

	@Override
	public Testimonial getTestimonialById(long id) {
		return testimonialRepository.findById(id).orElseThrow(() -> {
			return new ResourceNotFoundException("Testimonial", "ID", id);
		});
	}

	@Override
	public Testimonial addTestimonial(Testimonial testimonial) {
		return testimonialRepository.save(testimonial);
	}

	@Override
	public Testimonial updateTestimonial(Testimonial testimonial) {
		Testimonial existing = getTestimonialById(testimonial.getId());
		existing.setFirstName(testimonial.getFirstName());
		existing.setLastName(testimonial.getLastName());
		existing.setDescription(testimonial.getDescription());
		testimonialRepository.save(existing);
		return existing;
	}

	@Override
	public String deleteTestimonial(long id) {
		testimonialRepository.deleteById(id);
		return new String("Testimonial Deleted Succesfully!");
	}

}
