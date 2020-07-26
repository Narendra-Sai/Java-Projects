package com.lti.training.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.assignment.service.LoginService;

import dto.LoginDto;
import dto.UserDto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService<LoginDto> loginService;

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody LoginDto logindto) {
		UserDto loginuser = this.loginService.login(logindto);
		ResponseEntity<UserDto> response = new ResponseEntity<UserDto>(loginuser, HttpStatus.OK);
		return response;

	}
}