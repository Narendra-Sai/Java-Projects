package com.lti.training.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.assignment.service.AdminService;

import dto.MovieDto;
import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TheaterToMovieMapDto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminservice;

	@PostMapping("/addTheater")
	public ResponseEntity<TheaterDto> addTheater(@RequestBody TheaterDto theaterDetail) {
		TheaterDto theater = this.adminservice.addTheater(theaterDetail);
		ResponseEntity<TheaterDto> response = new ResponseEntity<TheaterDto>(theater, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getAllTheaters")
	public ResponseEntity<List<TheaterDto>> getAllTheaters() {
		List<TheaterDto> theaters = this.adminservice.getAllTheaters();
		ResponseEntity<List<TheaterDto>> response = new ResponseEntity<List<TheaterDto>>(theaters, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getAllScreens")
	public ResponseEntity<List<ScreenDto>> getAllScreens() {
		List<ScreenDto> screens = this.adminservice.getAllScreens();
		System.out.println("All screens for theater with shows :  " + screens.toString());
		ResponseEntity<List<ScreenDto>> response = new ResponseEntity<List<ScreenDto>>(screens, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getAllShows")
	public ResponseEntity<List<ShowDto>> getAllShows() {

		List<ShowDto> shows = this.adminservice.getAllShows();
		ResponseEntity<List<ShowDto>> response = new ResponseEntity<List<ShowDto>>(shows, HttpStatus.OK);
		return response;
	}

	@PostMapping("/addMovie")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDetail) {
		MovieDto movieAdded = this.adminservice.addMovie(movieDetail);
		ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(movieAdded, HttpStatus.OK);
		return response;
	}
	@PostMapping("/addScreen")
	public ResponseEntity<ScreenDto> addScreen(@RequestBody ScreenDto screenDetail) {
		ScreenDto screen = this.adminservice.addScreen(screenDetail);
		ResponseEntity<ScreenDto> response = new ResponseEntity<ScreenDto>(screen, HttpStatus.OK);
		return response;
	}

	@PostMapping("/addShow")
	public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDetail) {
		ShowDto show = this.adminservice.addShow(showDetail);
		ResponseEntity<ShowDto> response = new ResponseEntity<ShowDto>(show, HttpStatus.OK);
		return response;
	}

	

	@PostMapping("/linkTheaterToMovie")
	public ResponseEntity<Boolean> linkTheaterToMovie(@RequestBody TheaterToMovieMapDto linkDto) {
		Boolean isLinked = this.adminservice.linkTheaterToMovie(linkDto);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(isLinked, HttpStatus.OK);
		return response;
	}

	@GetMapping("/deleteMovie/{id}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable("id") long id) throws Exception {
		Boolean isdeleted = this.adminservice.deleteMovie(id);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(isdeleted, HttpStatus.OK);
		return response;
	}

	@PostMapping("/updateMovie")
	public ResponseEntity<Boolean> updateMovie(@RequestBody MovieDto movieDetail) throws Exception {
		Boolean isupdated = this.adminservice.updateMovie(movieDetail);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(isupdated, HttpStatus.OK);
		return response;
	}

}
