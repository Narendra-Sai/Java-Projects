package dto;

public class MovieTheaterMapDto {

	private long _id;
	private long movieid;
	private long theaterid;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public long getTheaterid() {
		return theaterid;
	}

	public void setTheaterid(long theaterid) {
		this.theaterid = theaterid;
	}

	@Override
	public String toString() {
		return "MovieTheaterMapping [_id=" + _id + ", movieid=" + movieid + ", theaterid=" + theaterid + ", get_id()="
				+ get_id() + ", getMovieid()=" + getMovieid() + ", getTheaterid()=" + getTheaterid() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
