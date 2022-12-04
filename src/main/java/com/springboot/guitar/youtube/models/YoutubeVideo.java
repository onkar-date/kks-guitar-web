package com.springboot.guitar.youtube.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "youtube")
public class YoutubeVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "source_url", nullable = false)
	private String sourceUrl;
	
	@Column(name = "title", nullable = false)
	private String title;
	
}
