package com.lti.training.assignment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.User;

@Repository
public class RegistrationRepositoryImpl<R> implements RegistrationRepository<Registration> {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User register(Registration registrationDetail, User user) {

		user = mongoTemplate.insert(user);
		registrationDetail = mongoTemplate.insert(registrationDetail);

		return user;
	}

}
