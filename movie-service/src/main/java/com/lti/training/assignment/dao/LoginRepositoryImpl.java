package com.lti.training.assignment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.User;

@Repository
public class LoginRepositoryImpl implements LoginRepository<Registration> {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User login(Registration userDetail) {
		Registration registration = mongoTemplate
				.findOne(
						Query.query(Criteria.where("email").is(userDetail.getEmail())
								.andOperator(Criteria.where("password").is(userDetail.getPassword()))),
						Registration.class);

		User user = mongoTemplate.findOne(Query.query(Criteria.where("userid").is(registration.getEmail())),
				User.class);
		return user;
	}

}
