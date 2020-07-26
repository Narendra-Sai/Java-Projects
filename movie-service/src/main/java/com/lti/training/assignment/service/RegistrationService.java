package com.lti.training.assignment.service;

import dto.UserDto;

public interface RegistrationService<RegistrationDto> {

	public UserDto register(RegistrationDto registrationDetail);

}
