package com.lti.training.assignment.document.entity.mapping;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieUserCommentMapping")
public class MovieUserCommentMapping {

	@Id
	private long _id;
	private long movieid;
	private long userid;
	private long commentid;
	
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
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getCommentid() {
		return commentid;
	}
	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}
	@Override
	public String toString() {
		return "MovieUserCommentMapping [_id=" + _id + ", movieid=" + movieid + ", userid=" + userid + ", commentid="
				+ commentid + ", get_id()=" + get_id() + ", getMovieid()=" + getMovieid() + ", getUserid()="
				+ getUserid() + ", getCommentid()=" + getCommentid() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
