package com.lti.training.assignment.document.entity.mapping;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ScreenTheaterMovieMap")
public class ScreenTheaterMovieMapping {

	@Transient
	public static final String SEQUENCE_NAME = "TheaterToScreenToScreen_sequence";

	@Id
	private long _id;
	private long screenid;
	private long theaterid;
	private long movieid;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long getTheaterid() {
		return theaterid;
	}

	public void setTheaterid(long theaterid) {
		this.theaterid = theaterid;
	}

	public Long getScreenid() {
		return screenid;
	}

	public void setScreenid(Long screenid) {
		this.screenid = screenid;
	}

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public void setScreenid(long screenid) {
		this.screenid = screenid;
	}

	@Override
	public String toString() {
		return "ScreenTheaterMovieMapping [_id=" + _id + ", screenid=" + screenid + ", theaterid=" + theaterid
				+ ", movieid=" + movieid + "]";
	}

}
