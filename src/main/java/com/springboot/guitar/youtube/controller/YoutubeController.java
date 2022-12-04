package com.springboot.guitar.youtube.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.guitar.youtube.models.YoutubeVideo;
import com.springboot.guitar.youtube.service.YoutubeService;

@RestController
@RequestMapping(value = "/api/youtube")
@CrossOrigin(origins = "http://localhost:3000")
public class YoutubeController {
	
	private YoutubeService youtubeService;
	
	public YoutubeController(YoutubeService youtubeService) {
		this.youtubeService = youtubeService;
	}
	
	@GetMapping
	public ResponseEntity<List<YoutubeVideo>> getAllYoutubeVideos() {
		return new ResponseEntity<List<YoutubeVideo>> (youtubeService.getAllYoutubeVideos(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<YoutubeVideo> getYoutubeVideoById(@PathVariable("id") long id) {
		return new ResponseEntity<YoutubeVideo> (youtubeService.getYoutubeVideoById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<YoutubeVideo> addYoutubeVideo(@RequestBody YoutubeVideo youtubeVideo) {
		return new ResponseEntity<YoutubeVideo> (youtubeService.addYoutubeVideo(youtubeVideo), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<YoutubeVideo> updateYoutubeVideo(@RequestBody YoutubeVideo youtubeVideo) {
		return new ResponseEntity<YoutubeVideo> (youtubeService.updateYoutubeVideo(youtubeVideo), HttpStatus.OK);
	}

}
