package utility;

public class UserSession {

	private String userid;
	private long movieid;
	private long theaterid;
	private long screenid;
	private long showid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (movieid ^ (movieid >>> 32));
		result = prime * result + (int) (screenid ^ (screenid >>> 32));
		result = prime * result + (int) (showid ^ (showid >>> 32));
		result = prime * result + (int) (theaterid ^ (theaterid >>> 32));
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		if (movieid != other.movieid)
			return false;
		if (screenid != other.screenid)
			return false;
		if (showid != other.showid)
			return false;
		if (theaterid != other.theaterid)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSession [userid=" + userid + ", movieid=" + movieid + ", theaterid=" + theaterid + ", screenid="
				+ screenid + ", showid=" + showid + "]";
	}

}
