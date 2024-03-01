package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController 
{
	

@GetMapping("/user")
public String showHomePage() {
	return "welcome";
}


//
//
//@GetMapping("/aboutus")
//public String aboutuspage() {
//	return "AboutUs";
//}
// @GetMapping("/contactus")
// public String contactus() {
//	 return "ContactUs";
// }
// 
// @GetMapping("/userlogin")
// public String userlog() {
//     return "UserLoginForm";
// }
}