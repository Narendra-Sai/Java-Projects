package dto;

public class TheaterToMovieMapDto {

	private long id;
	private long theaterid;
	private long screenid;
	private long showid;
	private long movieid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(long theaterid) {
		this.theaterid = theaterid;
	}
	public long getScreenid() {
		return screenid;
	}
	public void setScreenid(long screenid) {
		this.screenid = screenid;
	}
	public long getShowid() {
		return showid;
	}
	public void setShowid(long showid) {
		this.showid = showid;
	}
	public long getMovieid() {
		return movieid;
	}
	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	
	@Override
	public String toString() {
		return "TheaterToMovieMapDto [id=" + id + ", theaterid=" + theaterid + ", screenid=" + screenid + ", showid="
				+ showid + ", movieid=" + movieid + "]";
	}
	
	
}
