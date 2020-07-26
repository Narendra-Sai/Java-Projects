package com.lti.training.assignment.document.entity.mapping;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "showScreenMapping")
public class ShowScreenMapping {


	@Transient
	public static final String SEQUENCE_NAME = "ShowToScreen_sequence";
	
	@Id
	private long _id;
	private long screenid;
	private Long showid;
	
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public long getScreenid() {
		return screenid;
	}
	public void setScreenid(long screenid) {
		this.screenid = screenid;
	}
	public Long getShowid() {
		return showid;
	}
	public void setShowid(Long showid) {
		this.showid = showid;
	}
	
	@Override
	public String toString() {
		return "ShowScreenMapping [_id=" + _id + ", screenid=" + screenid + ", showid=" + showid + "]";
	}
	
	
	
	
}
