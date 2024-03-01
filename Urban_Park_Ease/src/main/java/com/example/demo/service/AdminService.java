package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AddAdminRegistration;
import com.example.demo.model.UserRegistrationmodel;
@Service
public interface AdminService 
{
    //void saveAdminUser(AdminUser a);

	List<UserRegistrationmodel> getAllUsers();
	
	AddAdminRegistration findByEmail(String email);

	void saveAdminUser(AddAdminRegistration addAdminReg);

	List<AddAdminRegistration> getAdminProfile(String email);

	

}
