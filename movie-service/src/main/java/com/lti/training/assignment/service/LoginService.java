package com.lti.training.assignment.service;

import dto.UserDto;

public interface LoginService <LoginDto>{

	public UserDto login(LoginDto user);
}
