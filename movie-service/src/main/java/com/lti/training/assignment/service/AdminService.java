package com.lti.training.assignment.service;

import java.util.List;

import dto.MovieDto;
import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TheaterToMovieMapDto;

public interface AdminService {

	public Boolean linkTheaterToMovie(TheaterToMovieMapDto linkmap);

	public MovieDto addMovie(MovieDto movieDetail);

	public Boolean updateMovie(MovieDto movieDetail) throws Exception;

	public Boolean deleteMovie(long movieid) throws Exception;

	public TheaterDto addTheater(TheaterDto theaterDetail);

	public List<TheaterDto> getAllTheaters();

	public List<ScreenDto> getAllScreens();

	public List<ShowDto> getAllShows();

	public ScreenDto addScreen(ScreenDto screen);

	public ShowDto addShow(ShowDto show);

	public Boolean associateMoviesToTheater(List<Long> movieids, long theaterid);

	public Boolean associateMovieToShow(long showid, long movieid);

	public Boolean associateShowsToScreen(List<Long> showids, long screenid);

	public Boolean associateScreensToTheater(List<Long> screenids, long theaterid);

}
