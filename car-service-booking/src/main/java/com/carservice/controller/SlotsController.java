package com.carservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;
import com.carservice.repository.AvailableSlotsRep;
import com.carservice.repository.DateSlotsRep;
import com.carservice.services.SlotsService;

@Controller
public class SlotsController {

	@Autowired
	private AvailableSlotsRep availableSlotsRep;

	@Autowired
	private DateSlotsRep dtSlotRep;

	@Autowired
	private SlotsService service;
	
	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}

	@RequestMapping(path = "/checkAvailability", method = RequestMethod.GET)
	public ModelAndView showSlots(@RequestParam String date, Model model) throws ParseException{

		model.addAttribute("date", date);

		ModelAndView mv = new ModelAndView("/checkAvailability");

		mv.addObject("slots", service.loadSlots(date));
		return mv;
	}


	@RequestMapping(value = "/bookSlot", method = RequestMethod.POST)
	public String saveBooking(@RequestParam String name, 
									@RequestParam String date, 
									@RequestParam String slot,
									Model model) throws ParseException {

		List<DateSlots> dates = dtSlotRep.findByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));

		AvailableSlots availableSlot = availableSlotsRep.findSlotUpdate(dates.get(0).getId(),slot);

		availableSlot.setName(name);
		availableSlot.setToken();
		availableSlot.setAvailable(true);
		availableSlot.setSlot(slot);

		availableSlotsRep.save(availableSlot);
		model.addAttribute("token", availableSlot.getToken());
		return "bookSlot";
	}
	
}

