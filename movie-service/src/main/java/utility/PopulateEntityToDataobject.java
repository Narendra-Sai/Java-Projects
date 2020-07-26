package utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lti.training.assignment.document.entity.Comment;
import com.lti.training.assignment.document.entity.Movie;
import com.lti.training.assignment.document.entity.Screen;
import com.lti.training.assignment.document.entity.Show;
import com.lti.training.assignment.document.entity.Theater;
import com.lti.training.assignment.document.entity.Ticket;
import com.lti.training.assignment.document.entity.User;

import dto.CommentDto;
import dto.MovieDto;
import dto.ScreenDto;
import dto.ShowDto;
import dto.TheaterDto;
import dto.TicketDto;
import dto.UserDto;

public class PopulateEntityToDataobject {

	public static UserDto populateUserDto(User user) {
		UserDto userdetail = new UserDto();
		userdetail.setUserid(user.getUserid());
		userdetail.setRole(user.getRole());
		userdetail.setId((user.get_id()));
		userdetail.setName(user.getName());
		return userdetail;

	}

	public static UserSession populateUserSession(User user) {
		UserSession usersession = new UserSession();
		usersession.setUserid(user.getUserid());
		return usersession;
	}

	public static List<MovieDto> populateMoviesDto(List<Movie> movies) {
		List<MovieDto> moviedtos = new ArrayList<>();
		for (Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			moviedtos.add(populateMovieDto(movie));
		}
		return moviedtos;
	}

	public static MovieDto populateMovieDto(Movie movie) {
		MovieDto moviedto = new MovieDto();
		moviedto.setId(movie.get_id());
		moviedto.setCover(movie.getCover());
		moviedto.setDescription(movie.getDescription());
		moviedto.setImg(movie.getImg());
		moviedto.setLength(movie.getLength());
		moviedto.setName(movie.getName());
		moviedto.setRating(movie.getRating());
		return moviedto;
	}

	public static CommentDto populateCommentDto(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.get_id());
		commentDto.setUserid(comment.getUserid());
		commentDto.setMovieid(comment.getMovieid());
		commentDto.setComment(comment.getComment());
		return commentDto;
	}

	public static List<TheaterDto> populateAllTheaterDtos(List<Theater> theaters) {
		List<TheaterDto> theaterDtos = new ArrayList<TheaterDto>();
		for (Iterator<Theater> iter = theaters.iterator(); iter.hasNext();) {
			theaterDtos.add(populateTheaterDto(iter.next()));
		}
		return theaterDtos;

	}

	public static TheaterDto populateTheaterDto(Theater theater) {

		TheaterDto theaterDto = new TheaterDto();
		theaterDto.setAddress(theater.getAddress());
		theaterDto.setCiti(theater.getCiti());
		theaterDto.setName(theater.getName());
		theaterDto.setid(theater.get_id());
		theaterDto.setImg(theater.getImg());
		theaterDto.setRating(theater.getRating());

		return theaterDto;
	}

	public static List<ScreenDto> populateTheaterScreen(List<Screen> screens, TheaterDto... theaterDto) {
		List<ScreenDto> screendtos = new ArrayList<ScreenDto>();
		for (Iterator<Screen> iter = screens.iterator(); iter.hasNext();) {
			ScreenDto screendto = new ScreenDto();
			Screen screen = iter.next();
			screendto.setName(screen.getName());
			screendto.setAvailability(screen.getAvailability());
			screendto.setCapacity(screen.getCapacity());
			screendto.setId(screen.get_id());

			if (screen.getShows() != null)
				screendto.setShowList(populateScreenShow(screen.getShows(), screendto));
			screendtos.add(screendto);
		}
		return screendtos;
	}

	public static List<ShowDto> populateScreenShow(List<Show> shows, ScreenDto screenDto) {
		List<ShowDto> showdtos = new ArrayList<ShowDto>();
		for (Iterator<Show> iter = shows.iterator(); iter.hasNext();) {
			ShowDto showdto = new ShowDto();
			Show show = iter.next();
			showdto.setId(show.get_id());
			showdto.setPrice(show.getPrice());
			showdto.seteTime(show.geteTime());
			showdto.setsTime(show.getsTime());
			showdto.setShowTime(show.getShowTime());
			showdtos.add(showdto);
		}
		return showdtos;
	}

	public static TicketDto populateShowTicket(Ticket ticket) {
		TicketDto ticketdto = new TicketDto();
		ticketdto.setMessage(ticket.getMessage());
		ticketdto.setMovieImg(ticket.getMovieImg());
		ticketdto.setMovieName(ticket.getMovieName());
		ticketdto.setShowTime(ticket.getShowTime());
		ticketdto.setShowid(ticket.getShowid());
		ticketdto.setId(ticket.get_id());
		return ticketdto;
	}

}
