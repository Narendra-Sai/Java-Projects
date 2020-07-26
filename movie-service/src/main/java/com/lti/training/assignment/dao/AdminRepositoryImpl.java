package com.lti.training.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.TheaterToMovieMap;
import com.lti.training.assignment.document.entity.mapping.ScreenTheaterMovieMapping;
import com.lti.training.assignment.document.entity.mapping.ShowScreenMapping;
import com.lti.training.assignment.service.SequenceGeneratorService;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Movie addMovie(Movie movie) {
		return mongoTemplate.insert(movie);
	}

	@Override
	public List<Theater> getAllTheaters() {
		return mongoTemplate.findAll(Theater.class);
	}

	@Override
	public Boolean updateMovie(Movie movie) throws Exception {
		try {
			mongoTemplate.upsert(Query.query(Criteria.where("_id").is(movie.get_id())),
					(Update.update("rating", movie.getRating())), Movie.class);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteMovie(long movieid) throws Exception {
		try {
			mongoTemplate.remove(Query.query(Criteria.where("_id").is(movieid)), Movie.class);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public List<Screen> getAllScreens() {
		return mongoTemplate.findAll(Screen.class);
	}

	@Override
	public List<Show> getAllShows() {
		return mongoTemplate.findAll(Show.class);
	}

	@Override
	public Theater addTheater(Theater theater) {
		return mongoTemplate.insert(theater);
	}

	@Override
	public Boolean linkTheaterToMovie(TheaterToMovieMap linkmap) {

		Boolean isLinked = false;
		ScreenTheaterMovieMapping screenTheaterMovieMap = new ScreenTheaterMovieMapping();
		screenTheaterMovieMap.setMovieid(linkmap.getMovieid());
		screenTheaterMovieMap.setScreenid(linkmap.getScreenid());
		screenTheaterMovieMap.setTheaterid(linkmap.getTheaterid());
		screenTheaterMovieMap
				.set_id(sequenceGeneratorService.generateSequence(ScreenTheaterMovieMapping.SEQUENCE_NAME));
		screenTheaterMovieMap = mongoTemplate.insert(screenTheaterMovieMap);

		/*
		 * MovieScreenMapping movieScreenMap = new MovieScreenMapping();
		 * 
		 * movieScreenMap.setMovieid(linkmap.getMovieid());
		 * movieScreenMap.setScreenid(linkmap.getScreenid());
		 * movieScreenMap.set_id(sequenceGeneratorService.generateSequence(
		 * MovieScreenMapping.SEQUENCE_NAME)); movieScreenMap =
		 * mongoTemplate.insert(movieScreenMap);
		 */
		/*
		 * MovieShowMapping movieShowMap = new MovieShowMapping();
		 * movieShowMap.setMovieid(linkmap.getMovieid());
		 * movieShowMap.setShowid(linkmap.getShowid());
		 * movieShowMap.set_id(sequenceGeneratorService.generateSequence(
		 * MovieShowMapping.SEQUENCE_NAME)); movieShowMap =
		 * mongoTemplate.insert(movieShowMap);
		 */

		ShowScreenMapping showScreenMap = new ShowScreenMapping();
		showScreenMap.setScreenid(linkmap.getScreenid());
		showScreenMap.setShowid(linkmap.getShowid());
		showScreenMap.set_id(sequenceGeneratorService.generateSequence(ShowScreenMapping.SEQUENCE_NAME));
		showScreenMap = mongoTemplate.insert(showScreenMap);

		/*
		 * MovieTheaterMapping movieTheaterMap = new MovieTheaterMapping();
		 * movieTheaterMap.setMovieid(linkmap.getMovieid());
		 * movieTheaterMap.setTheaterid(linkmap.getTheaterid());
		 * movieTheaterMap.set_id(sequenceGeneratorService.generateSequence(
		 * MovieTheaterMapping.SEQUENCE_NAME)); movieTheaterMap =
		 * mongoTemplate.insert(movieTheaterMap);
		 */

		/*
		 * TheaterShowMapping theaterShowMap = new TheaterShowMapping();
		 * theaterShowMap.setShowid(linkmap.getShowid());
		 * theaterShowMap.setTheaterid(linkmap.getTheaterid());
		 * theaterShowMap.set_id(sequenceGeneratorService.generateSequence(
		 * TheaterShowMapping.SEQUENCE_NAME)); theaterShowMap =
		 * mongoTemplate.insert(theaterShowMap);
		 */

		isLinked = true;

		return isLinked;
	}

	@Override
	public Screen addScreen(Screen screen) {
		return mongoTemplate.insert(screen);
	}

	@Override
	public Show addShow(Show show) {
		return mongoTemplate.insert(show);
	}

}
