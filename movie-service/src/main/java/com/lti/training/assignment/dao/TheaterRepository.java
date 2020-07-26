package com.lti.training.assignment.dao;

import java.util.List;

import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.Ticket;

import dto.UserPayload;

public interface TheaterRepository<T> {

	public Ticket showBooking(Ticket ticketdetail);

	public List<Theater> getAllTheaters(long movieid);

	public void deleteTheater(Theater theater);

	public List<Screen> getAllScreens(UserPayload userpayload);

	public List<Show> getAllShows(long screenid);

}
