package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.repository.IUserRegistrationRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	 IUserRegistrationRepository adUser;
 
	
}
