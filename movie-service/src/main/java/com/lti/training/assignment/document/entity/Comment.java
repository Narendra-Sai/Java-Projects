package com.lti.training.assignment.document.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
public class Comment {

	@Transient
	public static final String SEQUENCE_NAME = "comment_sequence";

	@Id
	private long _id;
	private long movieid;
	private long userid;
	private String comment;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "Comment [_id=" + _id + ", movieid=" + movieid + ", userid=" + userid + ", comment=" + comment + "]";
	}

}
