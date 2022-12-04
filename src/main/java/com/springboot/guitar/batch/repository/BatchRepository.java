package com.springboot.guitar.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.guitar.batch.models.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}
