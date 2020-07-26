package com.lti.training.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.assignment.dao.RegistrationRepository;
import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.User;

import dto.RegistrationDto;
import dto.UserDto;
import utility.PopulateDataobjectToEntity;
import utility.PopulateEntityToDataobject;

@Service
public class RegistrationServiceImpl<U> implements RegistrationService<RegistrationDto> {

	@Autowired
	RegistrationRepository<U> registrationRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public UserDto register(RegistrationDto registrationDetail) {

		// populate dto to entity
		User user = PopulateDataobjectToEntity.populateNewUser(registrationDetail);
		user.set_id(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));

		Registration registration = PopulateDataobjectToEntity.populateRegistration(registrationDetail);
		registration.set_id(user.get_id());

		user = registrationRepository.register(registration, user);
		// populate entity to dto
		UserDto userDtail = PopulateEntityToDataobject.populateUserDto(user);
		return userDtail;

	}

}
