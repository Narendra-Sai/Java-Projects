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

import com.lti.training.assignment.service.TheaterService;

import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TicketDto;
import dto.UserPayload;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TheaterController {

	@Autowired
	TheaterService<TheaterDto> theaterService;

	@PostMapping("/getAllTheatersById")
	public ResponseEntity<List<TheaterDto>> getAllTheatersById(@RequestBody UserPayload userpayload) {
		List<TheaterDto> theaters = this.theaterService.getAllTheaters(userpayload);
		ResponseEntity<List<TheaterDto>> response = new ResponseEntity<List<TheaterDto>>(theaters, HttpStatus.OK);
		return response;
	}

	@PostMapping("/getAllScreensByTheaterId")
	public ResponseEntity<List<ScreenDto>> getAllScreensByTheaterId(@RequestBody UserPayload userpayload) {
		List<ScreenDto> screens = this.theaterService.getAllScreens(userpayload);
		ResponseEntity<List<ScreenDto>> response = new ResponseEntity<List<ScreenDto>>(screens, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getAllShowsByMovieId/{movieid}")
	public ResponseEntity<List<ShowDto>> getAllShowsByMovieId(@PathVariable("movieid") long movieid) {
		List<ShowDto> shows = this.theaterService.getAllShows(movieid);
		ResponseEntity<List<ShowDto>> response = new ResponseEntity<List<ShowDto>>(shows, HttpStatus.OK);
		return response;
	}

	@PostMapping("/showBooking")
	public ResponseEntity<TicketDto> showBooking(@RequestBody TicketDto ticketdetail) {
		TicketDto ticket = this.theaterService.showBooking(ticketdetail);
		ResponseEntity<TicketDto> response = new ResponseEntity<TicketDto>(ticket, HttpStatus.OK);
		return response;
	}

}
