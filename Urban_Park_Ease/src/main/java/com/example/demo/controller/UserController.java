package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AddAdminRegistration;
import com.example.demo.model.BookingModel;
import com.example.demo.model.LoginForm;
import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.service.UserRegistrationService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserRegistrationService userService ;


	
	@GetMapping("/userlogin")
    public String userlog(Model m) 
	{
		UserRegistrationmodel userLogin = new UserRegistrationmodel();
		m.addAttribute("userLoginData",userLogin);
        return "UserLoginForm";
    }
		
	@GetMapping("/userlogout")
	public String userLogout(Model m, HttpServletRequest request, HttpSession session) 
	{
		session.invalidate();
		return "index";
		
	}
	
	
	@PostMapping("/userLoginFormP")
	   
	   public String addUserLoginData(@ModelAttribute ("userLoginData") UserRegistrationmodel userLoginData,
			   LoginForm form, HttpServletRequest request, HttpSession session, Model m) 
	   {
		session.invalidate();
		HttpSession newSession = request.getSession(true);
		String userEmail = form.getEmail();
		newSession.setAttribute("userEmail", userEmail);
		
		UserRegistrationmodel existingUser = userService.findByEmail(userLoginData.getEmail());
		if (existingUser != null && existingUser.getPassword().equals(userLoginData.getPassword()))
        {   return "UserDashBoard"; // Redirect to dashboard
        }
        
                else {
            m.addAttribute("error", "Invalid email or password");
           return "UserLoginForm"; // Return to login form with error message
                }
	   }
	

	
	 @RequestMapping("/viewUserProfile")
	 public String UserProfileView(Model m,HttpServletRequest request, HttpSession session) {
		
		 // Retrieve the user email from the session
	    String userEmail = (String) session.getAttribute("userEmail");
	    List<UserRegistrationmodel> userProfile = userService.getUserProfile(userEmail);
	    m.addAttribute("userProfile", userProfile);
		 return "UserProfile";
	 }
}
