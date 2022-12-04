package com.springboot.guitar.youtube.service;

import java.util.List;

import com.springboot.guitar.youtube.models.YoutubeVideo;

public interface YoutubeService {

	List<YoutubeVideo> getAllYoutubeVideos();
	
	YoutubeVideo getYoutubeVideoById(long id);
	
	YoutubeVideo addYoutubeVideo(YoutubeVideo youtubeVideo);
	
	YoutubeVideo updateYoutubeVideo(YoutubeVideo youtubeVideo);
	
	String deleteYoutubeVideo(long id);
}
