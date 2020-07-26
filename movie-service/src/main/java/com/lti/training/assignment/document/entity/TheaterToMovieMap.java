package com.lti.training.assignment.document.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TheaterToMovieMap")
public class TheaterToMovieMap {

	@Transient
	public static final String SEQUENCE_NAME = "theaterToMovieMap_sequence";

	@Id
	private long _id;
	private long theaterid;
	private long screenid;
	private long showid;
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
		return "TheaterToMovieMapDto [_id=" + _id + ", theaterid=" + theaterid + ", screenid=" + screenid + ", showid="
				+ showid + ", movieid=" + movieid + "]";
	}
	
	
}
