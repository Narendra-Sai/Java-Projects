package com.lti.training.assignment.document.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "screen")
public class Screen {

	@Transient
	public static final String SEQUENCE_NAME = "screen_sequence";

	@Id
	private long _id;
	private String name;
	private long capacity;
	private long availability;

	private List<Show> shows;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public long getAvailability() {
		return availability;
	}

	public void setAvailability(long availability) {
		this.availability = availability;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

}
