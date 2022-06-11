package com.carservice.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carservice.domain.model.BookedSlot;

@Controller
public class BookedSlotController {

	//@GetMapping("/getBookedSlot")
	public List<BookedSlot> listTest() {

		BookedSlot bkdSlot = new BookedSlot();
		bkdSlot.setId(1L);
		bkdSlot.setName("Test User1");
		bkdSlot.setToken("testtoken1");
		bkdSlot.setServiceDate("09-09-9999");
		bkdSlot.setSlot("1pm");

		BookedSlot bkdSlot2 = new BookedSlot();
		bkdSlot2.setId(2L);
		bkdSlot2.setName("Test User2");
		bkdSlot2.setToken("testtoken2");
		bkdSlot2.setServiceDate("09-09-9999");
		bkdSlot2.setSlot("2pm");

		return Arrays.asList(bkdSlot,bkdSlot2); 
	}

	@GetMapping public String getSlotsPage(Model model) { 
		model.addAttribute("slots", "Get all slots"); 
		return "all slots"; 
	}
	
	
	@RequestMapping("/getBookedSlot")
	public String getPage() {
		return "getBookedSlot";
	}


}
