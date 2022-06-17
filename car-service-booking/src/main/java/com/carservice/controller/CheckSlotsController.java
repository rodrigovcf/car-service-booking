package com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carservice.domain.model.BookedSlot;
import com.carservice.repository.BookedSlotRep;
import com.carservice.useful.Tokens;

@Controller
public class CheckSlotsController {

	@RequestMapping("/checkAvailability")
	public String showCheckAvailability() {
		return "checkAvailability";
	}
	
 
//	Selecionar Slots com Base na data
//	@RequestMapping("/checkAvailability")
//	public ModelAndView showSlots() {
//		List<>
//		return "checkAvailability";
//	}
	

	@Autowired
	private BookedSlotRep bookedSlotRep;

	//URI = /checkAvailability?date=<Date-selected-in-the-previous-screen
	@RequestMapping(value = "/checkAvailability", method = RequestMethod.POST)
	public ModelAndView saveBooking(BookedSlot bookedSlot) {

		String token = Tokens.tokenGenerate().substring(0,10);
		bookedSlot.setToken(token);

		bookedSlotRep.save(bookedSlot);
		ModelAndView mv = new ModelAndView("checkAvailability");
		mv.addObject("message","Booked successfully!");
		
		return mv;
	}


	//URI = /checkAvailability?date=<Date-selected-in-the-previous-screen
	//	@RequestMapping(value = "/checkAvailability", method = RequestMethod.POST)
	//	public String saveBooking(BookedSlot bookedSlot) {
	//		System.out.println(">>> " + bookedSlot.getName());
	//		System.out.println(">>> " + bookedSlot.getSlot());
	//		System.out.println(">>> " + bookedSlot.getServiceDate());
	//
	//		String token = Tokens.tokenGenerate().substring(0,10);
	//		bookedSlot.setToken(token);
	//		System.out.println(">>> " + bookedSlot.getToken());
	//		
	//		return "getBookedSlot";
	//	}

}
