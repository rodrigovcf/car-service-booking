package com.carservice.domain.model;

public class BookedSlot {
	
	private Long id;
	private String name;
	private String token; 
	private String service_date; //Alter to date
	private String slot; //Alter to enum
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getService_date() {
		return service_date;
	}
	public void setService_date(String service_date) {
		this.service_date = service_date;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
}
