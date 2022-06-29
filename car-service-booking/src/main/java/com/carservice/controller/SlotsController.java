package com.carservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;
import com.carservice.repository.AvailableSlotsRep;
import com.carservice.repository.DateSlotsRep;
import com.carservice.services.SlotsService;
import com.carservice.useful.CheckSlots;
import com.carservice.useful.DateComparation;

@Controller
public class SlotsController {

	@Autowired
	private AvailableSlotsRep availableSlotsRep;

	@Autowired
	private DateSlotsRep dtSlotRep;

	@Autowired
	private SlotsService service;
	
	private static String tokenParam = "token";
	private static String errorParam = "error";
	
	private List<AvailableSlots> slotsList; 
	
	@GetMapping(value = "/home")
	public String showHome() {
		return "home";
	}

	@GetMapping(path = "/checkAvailability")
	public ModelAndView showSlots(@RequestParam String date, Model model) throws ParseException{

		model.addAttribute("date", date);

		ModelAndView mv = new ModelAndView("/checkAvailability");
		
		slotsList = service.loadSlots(date);
		
		if(DateComparation.comparation(date)) {
			mv.addObject("slots", slotsList);
			return mv;
		}else {
			mv = new ModelAndView("home");
			mv.addObject("result", "The date cannot be less than the current date.(date)");
		}
			
		return mv;
	}


	@PostMapping(value = "/bookSlot")
	public ModelAndView saveBooking(@RequestParam String name, 
									@RequestParam String date, 
									@RequestParam String slot,
									Model model) throws ParseException {

		ModelAndView mv = new ModelAndView("/bookSlot");
		List<DateSlots> dates = dtSlotRep.findByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));

		if(CheckSlots.verifySlot(slotsList, slot)) {
			
			AvailableSlots availableSlot = availableSlotsRep.findSlotUpdate(dates.get(0).getId(),slot);

			availableSlot.setName(name);
			availableSlot.setToken();
			availableSlot.setAvailable(true);
			availableSlot.setSlot(slot);

			availableSlotsRep.save(availableSlot);
			model.addAttribute(tokenParam, availableSlot.getToken());
			return mv;
		}
		mv = new ModelAndView(errorParam);
		mv.addObject("result", "Slot not available!");
		
		return mv;
	}
	
	@GetMapping(path = "/getBookedSlot")
	public ModelAndView showBookedSlots(@RequestParam String token, Model model) {
		model.addAttribute(tokenParam, token);
		
		ModelAndView mv = new ModelAndView("/getBookedSlot");
		
		mv.addObject("slots",availableSlotsRep.findByToken(token));
		
		return mv; 
	}
	
	@GetMapping(path = "/cancel")
	public ModelAndView deleteBookedSlots(@RequestParam String token, Model model) {
		model.addAttribute(tokenParam, token);

		service.freeSlot(token);
		
		ModelAndView mv = new ModelAndView("/cancel");
		
		mv.addObject(tokenParam, token);
		
		return mv; 
	}
	
	@GetMapping(path = "/error")
	public ModelAndView errorShow(Errors errors) {
		
		ModelAndView mv = new ModelAndView(errorParam);
		
		mv.addObject(errorParam, errors);
		
		return mv; 
	}
	
}
