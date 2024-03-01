package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.AddAdminRegistration;
import com.example.demo.model.BookingModel;
import com.example.demo.model.LoginForm;
import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserRegistrationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService ;
	AdminRepository adminRepository;
	
	
    @GetMapping("/adminloginpage")
	 public String adminpage(Model m) 
     {
    	AddAdminRegistration ad = new AddAdminRegistration();
	    m.addAttribute("user",ad);
		 return "Adminloginform";
	 }
    
    


    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute ("user") AddAdminRegistration user, Model model,
    		 LoginForm form, HttpServletRequest request, HttpSession session) 
    {
    	session.invalidate();
    	HttpSession newAdminSession = request.getSession(true);
    	String adminEmail = form.getEmail();
    	newAdminSession.setAttribute("adminEmail", adminEmail);
    	
    	AddAdminRegistration existingUser = adminService.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword()))
        {  
        	return "AdminDashBoard"; // Redirect to dashboard
        }
        else {
            model.addAttribute("error", "Invalid email or password");
            return "Adminloginform"; // Return to login form with error message
             }
	
    }
    

    @GetMapping("/addAdminpage")
    public String showAdminRegForm(Model model) {
        model.addAttribute("AdminRegdata", new AddAdminRegistration());
        return "AddAdmin";
    }
     
   @PostMapping("/AdminRegistration")
   public String AddAdminRegForm(@ModelAttribute ("AdminRegdata") AddAdminRegistration AdminRegdata)
   {
	   adminService.saveAdminUser(AdminRegdata);
	   return "AdminDashBoard";
   }
   
   @GetMapping("/adminProfile")
	 public String adminProfile(Model m, HttpServletRequest request, HttpSession session) 
  {
	   String adminEmail = (String) session.getAttribute("adminEmail");
	    List<AddAdminRegistration> adminProfile = adminService.getAdminProfile(adminEmail);
	    m.addAttribute("adminProfile", adminProfile);
		 return "AdminProfile";
	 }
   
   @GetMapping("/adminHome")
   public String AdminHomePage(Model m) {
	   return "AdminDashBoard";
   }

}
