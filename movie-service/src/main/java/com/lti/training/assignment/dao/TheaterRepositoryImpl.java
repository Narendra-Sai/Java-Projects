package com.lti.training.assignment.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.Ticket;
import com.lti.training.assignment.document.entity.mapping.ScreenTheaterMovieMapping;
import com.lti.training.assignment.document.entity.mapping.ShowScreenMapping;

import dto.UserPayload;
import utility.UserSession;
import utility.UserSessionSingleton;

@Repository
public class TheaterRepositoryImpl<T> implements TheaterRepository<Theater> {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Theater> getAllTheaters(long movieid) {

		List<Long> theaterids = mongoTemplate.findDistinct(Query.query(Criteria.where("movieid").is(movieid)),
				"theaterid", ScreenTheaterMovieMapping.class, Long.class);

		List<Theater> theaters = mongoTemplate.find(Query.query(Criteria.where("_id").in(theaterids)), Theater.class);
		return theaters;
	}

	@Override
	public void deleteTheater(Theater theater) {
		mongoTemplate.remove(theater);
	}

	@Override
	public List<Screen> getAllScreens(UserPayload userpayload) {

		UserSession usersession = UserSessionSingleton.getInstance().getuser(userpayload.getUserid());
		List<Screen> screenlist = new ArrayList<Screen>();

		List<Long> screens = mongoTemplate.findDistinct(
				Query.query(Criteria.where("movieid").is(usersession.getMovieid())
						.andOperator(Criteria.where("theaterid").is(userpayload.getRequestId()))),
				"screenid", ScreenTheaterMovieMapping.class, Long.class);

		List<Screen> screenObjectList = mongoTemplate.find(Query.query(Criteria.where("_id").in(screens)),
				Screen.class);

		for (Iterator<Screen> iterator = screenObjectList.iterator(); iterator.hasNext();) {
			Screen screen = (Screen) iterator.next();
			List<Long> shows = mongoTemplate.findDistinct(Query.query(Criteria.where("screenid").is(screen.get_id())),
					"showid", ShowScreenMapping.class, Long.class);

			List<Show> showObjectList = mongoTemplate.find(Query.query(Criteria.where("_id").in(shows)), Show.class);
			screen.setShows(showObjectList);
			screenlist.add(screen);
		}
		return screenlist;

	}

	@Override
	public List<Show> getAllShows(long screenid) {
		return mongoTemplate.find(Query.query(Criteria.where("_id").is(screenid)), Show.class);
	}

	@Override
	public Ticket showBooking(Ticket ticket) {

		UserSession usersession = UserSessionSingleton.getInstance().getuser(ticket.getUserid());
		Movie movie = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(usersession.getMovieid())),
				Movie.class);
		Show show = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(ticket.getShowid())), Show.class);

		ticket.setShowTime(show.getShowTime());
		ticket.setMovieImg(movie.getImg());
		ticket.setMovieName(movie.getName());
		ticket.setShowid(show.get_id());
		ticket.setMessage("Congratulation...you have booked ticket for Movie " + movie.getName() + " for show time "
				+ " " + show.getShowTime() + "\n" + "Checkout your email inbox for ticket...Have a nice day...");
		ticket = mongoTemplate.insert(ticket);
		return ticket;
	}

}
