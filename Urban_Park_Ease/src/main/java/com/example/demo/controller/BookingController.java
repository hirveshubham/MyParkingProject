package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.BookingModel;
import com.example.demo.model.ProviderModel;
import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.repository.IUserRegistrationRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.ProviderService;
import com.example.demo.service.UserRegistrationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

	@Autowired
	BookingService bs;
	
	@Autowired
	ProviderService providerService;
	
	@Autowired
	UserRegistrationService userService;
	
	@GetMapping("/SlotBookingPage")
	public String Booking(Model m) 
	{
		BookingModel ad= new BookingModel();
		m.addAttribute("ConfirmSlot",ad);
		return "SlotBooking";
	}
	
	@GetMapping("/bookings")
	public String ViewBooking(Model m) 
	{
		 List<BookingModel> viewBookings = bs.getAllBookings();
	        m.addAttribute("bookingList", viewBookings);
		return "ViewBookings";
	}
	

	  @GetMapping("/deletes/{bid}")
	  public String deleteBooking(@PathVariable("bid") Long id,Model m) {
	  bs.deleteBookingById(id);
	  ViewBooking(m);
	      return "ViewBookings";
	  }
	  
	  @GetMapping("/deleteUserBooking/{bid}")
	  public String deleteUserBooking(@PathVariable("bid") Long id,Model m,HttpServletRequest r, HttpSession s) {
		  bs.deleteBookingById(id);
		  ViewUserBooking(m,r,s);
		      return "UserBookingHistory";
		  }
	
	  @GetMapping("/userHomePage")
	  public String UserHomePage(Model m) {
	      return "UserDashBoard";
	  }
	  
	  @GetMapping("/passProviderName/{pid}")
	  public String BookSlotByGivenProviderId(@PathVariable("pid") Long id,Model m,HttpServletRequest r, HttpSession s )
	  {
		  String userEmail = (String) s.getAttribute("userEmail");
		    UserRegistrationmodel userDetails = userService.findByEmail(userEmail);
		    m.addAttribute("userDetail", userDetails);
	 
	    ProviderModel viewProvidersForUser = providerService.getProviderById(id);
        m.addAttribute("providersForUser", viewProvidersForUser);
	        BookingModel ad= new BookingModel();
			m.addAttribute("ConfirmSlot",ad);
	       
		  return "SlotBooking";
	  }
	  
	@PostMapping("/BookingSlotData")
	public String AddBookingData(@ModelAttribute ("ConfirmSlot")BookingModel ConfirmSlot,Model m,HttpServletRequest r, HttpSession s ) 
	{
		bs.saveBookingData(ConfirmSlot);
		ViewUserBooking(m,r,s);
		return "UserBookingHistory";
	}
		
	@RequestMapping("/viewUserBooking")
	public String ViewUserBooking(Model m,HttpServletRequest request, HttpSession session) 
	{
		 // Retrieve the user email from the session
	    String userEmail = (String) session.getAttribute("userEmail");
	    List<BookingModel> userBookings = bs.getUserBookings(userEmail);
	    m.addAttribute("Bookings", userBookings);
	    
		return "UserBookingHistory";
	}
	
	
}
