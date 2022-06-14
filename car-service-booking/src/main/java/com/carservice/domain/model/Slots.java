
package com.carservice.domain.model;

public enum Slots {

	SLOT1("9am"),
	SLOT2("10am"),
	SLOT3("11am"),
	SLOT4("1pm"),
	SLOT5("2pm"),
	SLOT6("3pm"),
	SLOT7("4pm");
	
	private String slot;
	
	Slots(String slot){
		this.slot = slot;
	}
	
	public String getSlot() {
		return slot;
	}
}
