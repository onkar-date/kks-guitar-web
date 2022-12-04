package com.springboot.guitar.testimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.guitar.testimonial.models.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

}
