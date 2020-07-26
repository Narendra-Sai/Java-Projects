package com.lti.training.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.assignment.service.RegistrationService;

import dto.RegistrationDto;
import dto.UserDto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegistrationController {

	@Autowired
	RegistrationService<RegistrationDto> registrationService;

	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody RegistrationDto registrationDetail) {

		UserDto userDetails = this.registrationService.register(registrationDetail);
		ResponseEntity<UserDto> response = new ResponseEntity<UserDto>(userDetails, HttpStatus.OK);

		return response;
	}

}