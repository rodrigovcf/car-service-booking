package com.carservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}
	
//	@RequestMapping(value = "/checkAvailability", method = RequestMethod.POST)
//	public String getSlotAvailability(BookedSlot bookedSlot) {
//		
//		System.out.println("Data = " + bookedSlot.getServiceDate());
//		
//		return "checkAvailability";
//	}

}
