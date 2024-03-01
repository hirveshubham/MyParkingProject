package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingModel;

import com.example.demo.repository.BookingRepository;
@Service
public class BookingServiceImplementation implements BookingService{

	@Autowired
	 BookingRepository ad;
	
	@Override
	public void saveBookingData(BookingModel a) {
	 ad.save(a);
		
	}
	@Override
	public List<BookingModel> getAllBookings() {
		return ad.findAll();
	}
	
	@Override
    public void deleteBookingById(Long id) {
		ad.deleteById(id);
    }
	@Override
	public List<BookingModel> getUserBookings(String userEmail) {
		return ad.findByEmail(userEmail);
	}
}
