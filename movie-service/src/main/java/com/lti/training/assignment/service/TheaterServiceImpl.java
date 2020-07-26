package com.lti.training.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.assignment.dao.TheaterRepository;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.Ticket;

import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TicketDto;
import dto.UserPayload;
import utility.PopulateDataobjectToEntity;
import utility.PopulateEntityToDataobject;
import utility.UserSessionSingleton;

@Service
public class TheaterServiceImpl<T> implements TheaterService<TheaterDto> {

	@Autowired
	TheaterRepository<T> theaterRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public List<TheaterDto> getAllTheaters(UserPayload userpayload) {

		List<Theater> theaters = theaterRepository.getAllTheaters(userpayload.getRequestId());
		UserSessionSingleton.getInstance().getuser(userpayload.getUserid()).setTheaterid(userpayload.getRequestId());
		return PopulateEntityToDataobject.populateAllTheaterDtos(theaters);

	}

	@Override
	public List<ScreenDto> getAllScreens(UserPayload userpayload) {
		List<Screen> screens = theaterRepository.getAllScreens(userpayload);
		UserSessionSingleton.getInstance().getuser(userpayload.getUserid()).setTheaterid(userpayload.getRequestId());
		return PopulateEntityToDataobject.populateTheaterScreen(screens);
	}

	@Override
	public TicketDto showBooking(TicketDto ticketdetail) {
		Ticket ticket = PopulateDataobjectToEntity.populateShowTicket(ticketdetail);
		ticket.set_id(sequenceGeneratorService.generateSequence(Ticket.SEQUENCE_NAME));
		ticket = theaterRepository.showBooking(ticket);

		return PopulateEntityToDataobject.populateShowTicket(ticket);
	}

	@Override
	public List<ShowDto> getAllShows(long screenid) {
		List<Show> shows = theaterRepository.getAllShows(screenid);
		return PopulateEntityToDataobject.populateScreenShow(shows, null);
	}

	@Override
	public TheaterDto deleteTheater(TheaterDto theaterdetail) {
		// TODO Auto-generated method stub
		return null;
	}
}
