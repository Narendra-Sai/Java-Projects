package dto;

public class CommentDto {

	private long id;
	private long movieid;
	private long userid;
	private String comment;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMovieid() {
		return movieid;
	}
	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}

