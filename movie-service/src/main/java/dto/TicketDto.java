package dto;

public class TicketDto {

	private long id;
	private String movieImg;
	private String movieName;
	private String showTime;
	private String message;
	private long showid;
	private String userid;
	
	public String getMovieImg() {
		return movieImg;
	}
	public void setMovieImg(String movieImg) {
		this.movieImg = movieImg;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getShowid() {
		return showid;
	}
	public void setShowid(long showid) {
		this.showid = showid;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", movieImg=" + movieImg + ", movieName=" + movieName + ", showTime=" + showTime
				+ ", message=" + message + ", showid=" + showid + ", userid=" + userid + "]";
	}
	
}
