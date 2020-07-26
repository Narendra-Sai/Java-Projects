package com.lti.training.assignment.service;

import java.util.List;

import dto.ScreenDto;
import dto.ShowDto;
import dto.TicketDto;
import dto.UserPayload;

public interface TheaterService<TheaterDto> {

	public List<TheaterDto> getAllTheaters(UserPayload userpayload);

	public TheaterDto deleteTheater(TheaterDto theaterDetail);

	public List<ScreenDto> getAllScreens(UserPayload userpayload);

	public List<ShowDto> getAllShows(long screedid);

	public TicketDto showBooking(TicketDto ticketdetail);

}
