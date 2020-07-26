package com.lti.training.assignment.document.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long _id;
	private String name;
	private String userid;
	private String role;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private LocalDateTime deletedOn;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", userid=" + userid + ", role=" + role + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", deletedOn=" + deletedOn + "]";
	}

}
