package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AddAdminRegistration;
import com.example.demo.model.BookingModel;
import com.example.demo.model.ProviderModel;
import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.IUserRegistrationRepository;
@Service
public class AdminserviceImplementation implements AdminService 
{
     @Autowired
	 AdminRepository ad;
     IUserRegistrationRepository user;
    // BookingRepository bookingRepo;
     
  
//	@Override
//	public void saveAdminUser(AdminUser a) {
//		ad.save(a);	
//	}

	@Override
	public List<UserRegistrationmodel> getAllUsers() {
		return user.findAll();
	}
	
	@Override
	public void saveAdminUser(AddAdminRegistration adminAdd) {
		ad.save(adminAdd);
	}

	 @Override
	    public AddAdminRegistration findByEmail(String email) {
	        return ad.findByEmail(email);
	    }

	@Override
	public List<AddAdminRegistration> getAdminProfile(String email) {
		   return ad.findAdminByEmail(email);
	}
}
