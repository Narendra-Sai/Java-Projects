package com.lti.training.assignment.dao;

import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.User;

public interface RegistrationRepository<R> {

	public User register(Registration registration, User user);
}
