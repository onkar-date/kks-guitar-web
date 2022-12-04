package com.springboot.guitar.youtube.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.guitar.youtube.models.YoutubeVideo;
import com.springboot.guitar.youtube.repository.YoutubeRepository;
import com.springboot.guitar.youtube.service.YoutubeService;
import com.springboot.guitar.batch.exceptions.ResourceNotFoundException;

@Service
public class YoutubeImpl implements YoutubeService {
	
	private YoutubeRepository youtubeRepository;
	
	public YoutubeImpl(YoutubeRepository youtubeRepository) {
		this.youtubeRepository = youtubeRepository;
	}

	@Override
	public List<YoutubeVideo> getAllYoutubeVideos() {
		return youtubeRepository.findAll();
	}

	@Override
	public YoutubeVideo getYoutubeVideoById(long id) {
		return youtubeRepository.findById(id).orElseThrow(() -> {
			return new ResourceNotFoundException("Youtube Video", "ID", id);
		});
	}

	@Override
	public YoutubeVideo addYoutubeVideo(YoutubeVideo youtubeVideo) {
		String sourceUrl = youtubeVideo.getSourceUrl();
		youtubeVideo.setSourceUrl(sourceUrl.replace("watch?v=", "embed/"));
		return youtubeRepository.save(youtubeVideo);
	}

	@Override
	public YoutubeVideo updateYoutubeVideo(YoutubeVideo youtubeVideo) {
		YoutubeVideo existing = getYoutubeVideoById(youtubeVideo.getId());
		existing.setSourceUrl(youtubeVideo.getSourceUrl());
		existing.setTitle(youtubeVideo.getTitle());
		youtubeRepository.save(existing);
		return existing;
	}

	@Override
	public String deleteYoutubeVideo(long id) {
		youtubeRepository.deleteById(id);
		return "Youtube Video Deleted Successfully!!";
	}

}
