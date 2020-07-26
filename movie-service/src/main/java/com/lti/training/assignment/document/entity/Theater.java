package com.lti.training.assignment.document.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "theater")
public class Theater {

	@Transient
	public static final String SEQUENCE_NAME = "theater_sequence";

	@Id
	private long _id;
	private String name;
	private String address;
	private String citi;
	private String img;
	private double rating;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCiti() {
		return citi;
	}

	public void setCiti(String citi) {
		this.citi = citi;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Theater [_id=" + _id + ", name=" + name + ", address=" + address + ", citi=" + citi + "]";
	}

}
