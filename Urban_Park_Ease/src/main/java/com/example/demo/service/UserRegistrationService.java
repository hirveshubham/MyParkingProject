package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BookingModel;
import com.example.demo.model.UserRegistrationmodel;
@Service
public interface UserRegistrationService {

	 void saveUserRegistration(UserRegistrationmodel userRegform);
		
	List<UserRegistrationmodel> getAllUsers();

	void deleteUserById(Long id);
		
	void saveUserLoginData(UserRegistrationmodel a);

	UserRegistrationmodel findByEmail(String email);

	List<UserRegistrationmodel> getUserProfile(String email);
	
	
}
