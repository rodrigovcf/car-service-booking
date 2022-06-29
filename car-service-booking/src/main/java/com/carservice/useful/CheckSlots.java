package com.carservice.useful;

import java.util.List;

import com.carservice.domain.model.AvailableSlots;

public class CheckSlots {
	
	private CheckSlots() {}
	
	public static boolean verifySlot(List<AvailableSlots> slots, String slot) {

		for(AvailableSlots s: slots) {
			if(s.getSlot().equals(slot)){
				return true;
			}
		}
		
		return false;
	}

}
