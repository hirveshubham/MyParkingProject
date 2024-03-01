package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.BookingModel;
import com.example.demo.model.LoginForm;
import com.example.demo.model.ProviderModel;
import com.example.demo.model.UserRegistrationmodel;
import com.example.demo.service.ProviderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ViewProviderController {
	   @Autowired
	   ProviderService providerService;

	    @GetMapping("/viewProviders") 
	    public String getProviders(Model model) {
        List<ProviderModel> viewProviders = providerService.getAllProviders();
        model.addAttribute("providers", viewProviders);
	        return "ViewProviders";
	    }
	    

		  @GetMapping("/deleteProvider/{id}")
		  public String deleteBooking(@PathVariable("id") Long id,Model m) {
	      providerService.deleteProviderById(id);
	      getProviders(m);
		      return "ViewProviders";
		  }
	    
		  @GetMapping("/viewProviderForBooking")
		  public String getProvidersForUser(Model m) {
			  List<ProviderModel> viewProvidersForUser = providerService.getAllProviders();
		        m.addAttribute("providersForUser", viewProvidersForUser);
			  return "UserProviderList";
		  }
		  
		  @GetMapping("/addProvider")
			public String addProvider(Model m) 
			{
				ProviderModel ad= new ProviderModel();
				m.addAttribute("Aprovidrform",ad);
				return "AddProviderform";
			}
			
		  @GetMapping("/editProvider/{id}")
		  public String UpdateProviderByGivenProviderId(@PathVariable("id") Long id,Model m )
		  {

			  ProviderModel provider = providerService.getProviderById(id);
			    m.addAttribute("UpdateProviderform", provider);
			    
//			    ProviderModel pm = new ProviderModel();
//			     m.addAttribute("UpdateProvider",pm);
			    
			 //   m.addAttribute("UpdateProviderform", new ProviderModel()); // Add UpdateProviderform to the model
			    return "EditProvider";
					
			 // return "ViewProviders";
		  }
		  
			/*
			 * @PostMapping("/UpdateProviderData") public String
			 * UpdateProviderDataForm(@ModelAttribute ProviderModel UpdateProviderform,
			 * Model m ) {
			 * 
			 * providerService.saveProvider(UpdateProviderform); getProviders(m); return
			 * "ViewProviders"; }
			 */
		  
		  @PostMapping("/UpdateProviderData")
		  public String UpdateProviderDataForm(
		      @RequestParam("providerId") Long providerId,
		      @RequestParam("providerName") String providerName,
		      @RequestParam("address") String address,
		      @RequestParam("numberOfSlots") int slotCapacity,
		      @RequestParam("mobile") String mobile,
		      Model m) 
		  {
		      ProviderModel UpdateProviderform = new ProviderModel();
		      UpdateProviderform.setProviderId(providerId);
		      UpdateProviderform.setProviderName(providerName);
		      UpdateProviderform.setAddress(address);
		      UpdateProviderform.setSlotCapacity(slotCapacity);
		      UpdateProviderform.setMobile(mobile);

		      providerService.saveProvider(UpdateProviderform);
		      getProviders(m);
		      return "ViewProviders";
		  }
		  
	
		  		
			@PostMapping("/Addproviderdata") 
			public String AddProviderDatamethod(@ModelAttribute ("Aprovidrform")ProviderModel Aproviderform, Model m )
			{ 
				providerService.saveProvider(Aproviderform); 
				getProviders(m);
		    return "ViewProviders";
			}
		 
}
