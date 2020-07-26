package com.lti.training.assignment.service;

import java.util.List;

import dto.CommentDto;
import dto.MovieDto;
import dto.UserPayload;

public interface MovieService {

	public List<MovieDto> getMovies();

	public MovieDto getMovieById(UserPayload userpayload);

	public CommentDto addComment(CommentDto commentDto);

}
