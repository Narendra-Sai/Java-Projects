package com.lti.training.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.assignment.service.MovieService;

import dto.CommentDto;
import dto.MovieDto;
import dto.UserPayload;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MovieController {

	@Autowired
	MovieService movieservice;

	@GetMapping("/allMovies")
	public ResponseEntity<List<MovieDto>> getMovies() {
		List<MovieDto> movieDetails = this.movieservice.getMovies();
		ResponseEntity<List<MovieDto>> response = new ResponseEntity<List<MovieDto>>(movieDetails, HttpStatus.OK);
		return response;
	}

	@PostMapping("/getMovieById")
	public ResponseEntity<MovieDto> getMovieById(@RequestBody UserPayload userpayload) {
		MovieDto movieDetail = this.movieservice.getMovieById(userpayload);
		ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(movieDetail, HttpStatus.OK);
		return response;
	}

	
	@PostMapping("/addComment")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentdetail) {
		CommentDto commentAdded = this.movieservice.addComment(commentdetail);
		ResponseEntity<CommentDto> response = new ResponseEntity<CommentDto>(commentAdded, HttpStatus.OK);
		return response;
	}
}
