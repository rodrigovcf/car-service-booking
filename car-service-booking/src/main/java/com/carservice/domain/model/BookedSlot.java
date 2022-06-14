package com.carservice.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BookedSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String token; 
	
	@Temporal(TemporalType.DATE)
	private Date serviceDateSlot; 
	
	@Enumerated(EnumType.STRING)
	private Slots slot;
	
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
	public Date getServiceDate() {
		return serviceDateSlot;
	}
	public void setServiceDate(Date serviceDateSlot) {
		this.serviceDateSlot = serviceDateSlot;
	}
	public Slots getSlot() {
		return slot;
	}
	public void setSlot(Slots slot) {
		this.slot = slot;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, slot, token);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookedSlot other = (BookedSlot) obj;
		return Objects.equals(id, other.id) && slot == other.slot && Objects.equals(token, other.token);
	}
	
}