package com.lti.training.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.assignment.dao.LoginRepository;
import com.lti.training.assignment.document.entity.Registration;
import com.lti.training.assignment.document.entity.User;

import dto.LoginDto;
import dto.UserDto;
import utility.PopulateDataobjectToEntity;
import utility.PopulateEntityToDataobject;
import utility.UserSession;
import utility.UserSessionSingleton;

@Service
public class LoginServiceImpl implements LoginService<LoginDto> {

	@Autowired
	LoginRepository<Registration> loginRepository;

	@Override
	public UserDto login(LoginDto logindetail) {
		Registration loginuser = PopulateDataobjectToEntity.populateRegistration(logindetail);
		User user = loginRepository.login(loginuser);
		UserSession usersession = PopulateEntityToDataobject.populateUserSession(user);
		UserSessionSingleton.getInstance().setuser(user.getUserid(), usersession);
		return PopulateEntityToDataobject.populateUserDto(user);
	}

}
