package com.springboot.guitar.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.guitar.youtube.models.YoutubeVideo;

public interface YoutubeRepository extends JpaRepository<YoutubeVideo, Long> {

}
