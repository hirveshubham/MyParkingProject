package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BookingModel;
@Service
public interface BookingService {

	void saveBookingData(BookingModel a);

	List<BookingModel> getAllBookings();

	void deleteBookingById(Long id);
	
	List<BookingModel> getUserBookings(String userEmail);
}
