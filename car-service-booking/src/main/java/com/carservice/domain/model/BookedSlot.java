package com.carservice.domain.model;

public class BookedSlot {
	
	private Long id;
	private String name;
	private String token; 
	private String serviceDateSlot; //Alter to date
	private String slot; //Alter to enum for example
	
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
	public String getServiceDate() {
		return serviceDateSlot;
	}
	public void setServiceDate(String serviceDateSlot) {
		this.serviceDateSlot = serviceDateSlot;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
}
