package com.lti.training.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.assignment.dao.MovieDetailRepository;
import com.lti.training.assignment.document.entity.Comment;
import com.lti.training.assignment.document.entity.Movie;

import dto.CommentDto;
import dto.MovieDto;
import dto.UserPayload;
import utility.PopulateDataobjectToEntity;
import utility.PopulateEntityToDataobject;
import utility.UserSessionSingleton;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDetailRepository movieDetailRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public List<MovieDto> getMovies() {
		List<Movie> movies = movieDetailRepository.getAllMovies();
		return PopulateEntityToDataobject.populateMoviesDto(movies);

	}

	@Override
	public MovieDto getMovieById(UserPayload userpayload) {
		Movie movie = movieDetailRepository.getMovieById(userpayload.getRequestId());
		UserSessionSingleton.getInstance().getuser(userpayload.getUserid()).setMovieid(userpayload.getRequestId());
		MovieDto moviedto = PopulateEntityToDataobject.populateMovieDto(movie);

		return moviedto;
	}

	@Override
	public CommentDto addComment(CommentDto commentDto) {
		// populate dto to entity
		Comment comment = PopulateDataobjectToEntity.populateComment(commentDto);
		comment.set_id(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
		comment = movieDetailRepository.addComment(comment);
		// populate entity to dto
		return PopulateEntityToDataobject.populateCommentDto(comment);
	}

}
