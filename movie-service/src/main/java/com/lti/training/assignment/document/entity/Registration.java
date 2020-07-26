package com.lti.training.assignment.document.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registration")
public class Registration {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long _id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String cnfPassword;
	private String role;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcnfPassword() {
		return cnfPassword;
	}

	public void setcnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}

	public String getCnfPassword() {
		return cnfPassword;
	}

	public void setCnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Registration [userid=" + _id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", cnfPassword=" + cnfPassword + ", role=" + role
				+ ", getUserid()=" + get_id() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getcnfPassword()=" + getcnfPassword() + ", getCnfPassword()=" + getCnfPassword() + ", getRole()="
				+ getRole() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
