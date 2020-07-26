package com.lti.training.assignment.document.entity;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {

	@Transient
	public static final String SEQUENCE_NAME = "movie_sequence";

	@Id
	private long _id;
	private String name;
	private String description;
	private String length;
	private String img;
	private String cover;
	private String rating;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", description=" + description + ", length=" + length + ", img=" + img
				+ ", cover=" + cover + ", rating=" + rating + "]";
	}

}

class ZonedDateTimeReadConverter implements Converter<Date, ZonedDateTime> {
	@Override
	public ZonedDateTime convert(Date date) {
		return date.toInstant().atZone(ZoneOffset.UTC);
	}
}

class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {
	@Override
	public Date convert(ZonedDateTime zonedDateTime) {
		return Date.from(zonedDateTime.toInstant());
	}
}
