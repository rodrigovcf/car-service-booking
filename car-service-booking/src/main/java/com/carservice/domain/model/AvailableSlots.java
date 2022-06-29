package com.carservice.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.carservice.useful.Tokens;

@Entity
@Table(name = "tb_available_slots")
public class AvailableSlots implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_date")
	private DateSlots date;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "token", nullable = true)
	private String token;

	@Column(name = "slot")
	private String slot;

	private Boolean available;

	public AvailableSlots() {}

	public AvailableSlots(Long id, DateSlots date, String name, String token, String slot, Boolean available) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.token = token;
		this.slot = slot;
		this.available = available;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DateSlots getDate() {
		return date;
	}
	public void setDate(DateSlots date) {
		this.date = date;
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
	public void setToken() {
		String generationToken = Tokens.tokenGenerate().substring(0,10);
		this.token = generationToken;
	}
	public void setTokenNull() {
		this.token = null;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailableSlots other = (AvailableSlots) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvailableSlots [id=" + id + ", date=" + date + ", name=" + name + ", token=" + token + ", slot=" + slot
				+ ", available=" + available + "]";
	}



}




