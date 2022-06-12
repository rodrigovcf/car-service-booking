package com.carservice.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckSlotsController {
	
	@RequestMapping("/checkAvailability")
	public String showHome() {
		return "checkAvailability";
	}

}
