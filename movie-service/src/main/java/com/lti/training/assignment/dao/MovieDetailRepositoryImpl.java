package com.lti.training.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.training.assignment.document.entity.Comment;
import com.lti.training.assignment.document.entity.Movie;

@Repository
public class MovieDetailRepositoryImpl implements MovieDetailRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = mongoTemplate.findAll(Movie.class);
		return movieList;
	}

	@Override
	public Movie getMovieById(long movieID) {
		return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(movieID)), Movie.class);
	}

	@Override
	public Comment addComment(Comment comment) {
		return mongoTemplate.insert(comment);
	}

}
