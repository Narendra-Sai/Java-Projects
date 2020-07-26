package com.lti.training.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.assignment.dao.AdminRepository;
import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.TheaterToMovieMap;

import dto.MovieDto;
import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TheaterToMovieMapDto;
import utility.PopulateDataobjectToEntity;
import utility.PopulateEntityToDataobject;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminrepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public MovieDto addMovie(MovieDto movieDetail) {
		// populate dto to entity
		Movie movie = PopulateDataobjectToEntity.populateMovie(movieDetail);
		movie.set_id(sequenceGeneratorService.generateSequence(Movie.SEQUENCE_NAME));
		movie = adminrepository.addMovie(movie);
		// populate entity to dto
		return PopulateEntityToDataobject.populateMovieDto(movie);
	}

	@Override
	public Boolean linkTheaterToMovie(TheaterToMovieMapDto linkmap) {
		TheaterToMovieMap linkedmap = PopulateDataobjectToEntity.populateTheaterToMovieMap(linkmap);
		linkedmap.set_id(sequenceGeneratorService.generateSequence(TheaterToMovieMap.SEQUENCE_NAME));

		return adminrepository.linkTheaterToMovie(linkedmap);
	}

	@Override
	public Boolean updateMovie(MovieDto movieDetail) throws Exception {
		// populate dto to entity
		Movie movie = PopulateDataobjectToEntity.populateMovie(movieDetail);
		return adminrepository.updateMovie(movie);
	}

	@Override
	public Boolean deleteMovie(long movieid) throws Exception {
		return adminrepository.deleteMovie(movieid);
	}

	@Override
	public TheaterDto addTheater(TheaterDto theaterdetail) {
		// populate dto to entity
		Theater theater = PopulateDataobjectToEntity.populateTheater(theaterdetail);
		theater.set_id(sequenceGeneratorService.generateSequence(Theater.SEQUENCE_NAME));
		theater = adminrepository.addTheater(theater);
		// populate entity to dto
		return PopulateEntityToDataobject.populateTheaterDto(theater);
	}

	@Override
	public List<TheaterDto> getAllTheaters() {
		List<Theater> theaters = adminrepository.getAllTheaters();
		return PopulateEntityToDataobject.populateAllTheaterDtos(theaters);

	}

	@Override
	public List<ScreenDto> getAllScreens() {

		List<Screen> screens = adminrepository.getAllScreens();
		// populate entity to dto
		return PopulateEntityToDataobject.populateTheaterScreen(screens);
	}

	@Override
	public List<ShowDto> getAllShows() {
		List<Show> shows = adminrepository.getAllShows();
		// populate entity to dto
		return PopulateEntityToDataobject.populateScreenShow(shows, null);
	}

	public ScreenDto addScreen(ScreenDto screendetail) {
		Screen screen = PopulateDataobjectToEntity.populateScreen(screendetail);
		screen.set_id(sequenceGeneratorService.generateSequence(Screen.SEQUENCE_NAME));
		screen = adminrepository.addScreen(screen);
		return screendetail;
	}

	public ShowDto addShow(ShowDto showdetail) {
		Show show = PopulateDataobjectToEntity.populateShow(showdetail);
		show.set_id(sequenceGeneratorService.generateSequence(Show.SEQUENCE_NAME));
		show = adminrepository.addShow(show);
		return showdetail;
	}

	@Override
	public Boolean associateMoviesToTheater(List<Long> movieids, long theaterid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean associateMovieToShow(long showid, long movieid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean associateShowsToScreen(List<Long> showids, long screenid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean associateScreensToTheater(List<Long> screenids, long theaterid) {
		// TODO Auto-generated method stub
		return null;
	}

}
