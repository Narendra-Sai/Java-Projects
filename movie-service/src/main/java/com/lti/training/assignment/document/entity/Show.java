package com.lti.training.assignment.document.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "show")
public class Show {

	@Transient
	public static final String SEQUENCE_NAME = "show_sequence";

	@Id
	private long _id;
	private String sTime;
	private String eTime;
	private String price;
	private String showTime;

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "Show [_id=" + _id + ", sTime=" + sTime + ", eTime=" + eTime + ", price=" + price + ", showTime="
				+ showTime + "]";
	}

}
