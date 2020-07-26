package com.lti.training.assignment.dao;

import java.util.List;

import com.lti.training.assignment.document.entity.Comment;
import com.lti.training.assignment.document.entity.Movie;

public interface MovieDetailRepository {

	public List<Movie> getAllMovies();

	public Comment addComment(Comment comment);

	public Movie getMovieById(long movieID);

}
