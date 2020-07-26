package com.lti.training.assignment.dao;

import java.util.List;

import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.TheaterToMovieMap;

public interface AdminRepository {

	public Movie addMovie(Movie movie);

	public Boolean linkTheaterToMovie(TheaterToMovieMap linkmap);

	public Boolean updateMovie(Movie movie) throws Exception;

	public Boolean deleteMovie(long movieid) throws Exception;

	public Theater addTheater(Theater theaterDetail);

	public List<Theater> getAllTheaters();

	public List<Screen> getAllScreens();

	public List<Show> getAllShows();

	public Screen addScreen(Screen screen);

	public Show addShow(Show show);

}
