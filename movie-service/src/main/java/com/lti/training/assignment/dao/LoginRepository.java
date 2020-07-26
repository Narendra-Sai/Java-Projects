package com.lti.training.assignment.dao;

import com.lti.training.assignment.document.entity.User;

public interface LoginRepository<Registration> {

	public User login(Registration user);

}
