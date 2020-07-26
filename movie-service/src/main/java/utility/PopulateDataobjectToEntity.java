package utility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lti.training.assignment.document.entity.Comment;
import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.TheaterToMovieMap;
import com.lti.training.assignment.document.entity.Ticket;
import com.lti.training.assignment.document.entity.User;

import dto.CommentDto;
import dto.LoginDto;
import dto.MovieDto;
import dto.RegistrationDto;
import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TheaterToMovieMapDto;
import dto.TicketDto;

public class PopulateDataobjectToEntity {

	public static Registration populateRegistration(RegistrationDto registrationDetail) {

		Registration registration = new Registration();

		registration.setFirstName(registrationDetail.getFirstName());
		registration.setLastName(registrationDetail.getLastName());
		registration.setEmail(registrationDetail.getEmail());
		registration.setPassword(registrationDetail.getPassword());
		registration.setcnfPassword(registrationDetail.getcnfPassword());
		registration.setRole("USER");
		return registration;
	}

	public static TheaterToMovieMap populateTheaterToMovieMap(TheaterToMovieMapDto linkMap) {
		TheaterToMovieMap linkedMap = new TheaterToMovieMap();
		linkedMap.setMovieid(linkMap.getMovieid());
		linkedMap.setTheaterid(linkMap.getTheaterid());
		linkedMap.setScreenid(linkMap.getScreenid());
		linkedMap.setShowid(linkMap.getShowid());
		return linkedMap;
	}

	public static User populateNewUser(RegistrationDto registrationDetail) {
		User user = new User();
		user.setName(registrationDetail.getFirstName() + " " + registrationDetail.getLastName());
		user.setUserid(registrationDetail.getEmail());
		user.setCreatedOn(LocalDateTime.now());
		user.setRole("USER");
		return user;
	}

	public static Registration populateRegistration(LoginDto logindetail) {

		Registration registration = new Registration();
		registration.setEmail(logindetail.getUserid());
		registration.setPassword(logindetail.getPassword());
		return registration;
	}

	public static Theater populateTheater(TheaterDto theaterdetail) {
		Theater theater = new Theater();
		theater.setAddress(theaterdetail.getAddress());
		theater.setCiti(theaterdetail.getCiti());
		theater.setName(theaterdetail.getName());
		theater.setImg(theaterdetail.getImg());
		theater.setRating(theaterdetail.getRating());
		return theater;
	}

	public static void populateScreenShow(Screen screen, ScreenDto screenDto) {
		List<ShowDto> sDtos = screenDto.getShowList();
		List<Show> shows = new ArrayList<Show>();
		for (Iterator<ShowDto> iter = sDtos.iterator(); iter.hasNext();) {
			Show show = new Show();
			ShowDto showDto = iter.next();
			show.setPrice(showDto.getPrice());
			show.seteTime(showDto.geteTime());
			show.setsTime(showDto.getsTime());
			shows.add(show);
		}
	}

	public static Movie populateMovie(MovieDto moviedetail) {
		Movie movie = new Movie();
		movie.set_id(moviedetail.getId());
		movie.setCover(moviedetail.getCover());
		movie.setDescription(moviedetail.getDescription());
		movie.setImg(moviedetail.getImg());
		movie.setLength(moviedetail.getLength());
		movie.setName(moviedetail.getName());
		movie.setRating(moviedetail.getRating());
		return movie;
	}

	public static Screen populateScreen(ScreenDto screendetail) {
		Screen screen = new Screen();
		screen.setName(screendetail.getName());
		screen.setAvailability(screendetail.getAvailability());
		screen.setCapacity(screendetail.getCapacity());
		return screen;
	}

	public static Comment populateComment(CommentDto commentdetail) {
		Comment comment = new Comment();
		comment.setUserid(commentdetail.getUserid());
		comment.setMovieid(commentdetail.getMovieid());
		comment.setComment(commentdetail.getComment());
		return comment;
	}

	public static Show populateShow(ShowDto showdetail) {
		Show show = new Show();
		show.setPrice(showdetail.getPrice());
		show.seteTime(showdetail.geteTime());
		show.setsTime(showdetail.getsTime());
		show.setShowTime(showdetail.getsTime() + " - " + showdetail.geteTime());
		return show;
	}

	public static Ticket populateShowTicket(TicketDto ticketdto) {
		Ticket ticket = new Ticket();
		ticket.setMessage(ticketdto.getMessage());
		ticket.setMovieImg(ticketdto.getMovieImg());
		ticket.setMovieName(ticketdto.getMovieName());
		ticket.setShowTime(ticketdto.getShowTime());
		ticket.setShowid(ticketdto.getShowid());
		ticket.setUserid(ticketdto.getUserid());
		return ticket;
	}

}
