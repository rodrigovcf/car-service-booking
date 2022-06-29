package com.carservice.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_dates")
public class DateSlots implements Serializable{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_slot", nullable = false, unique = true)
	private Date date;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "date", targetEntity = AvailableSlots.class, cascade=CascadeType.ALL)
	private List<AvailableSlots> availableSlots;

	public DateSlots() {}
	
	public DateSlots(Date date, Long id) {
		super();
		this.date = date;
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public List<AvailableSlots> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(List<AvailableSlots> availableSlots) {
		this.availableSlots = availableSlots;
	}
	
	public void addAvailableSlots(AvailableSlots avSlot) {
		if(avSlot != null) {
			if(availableSlots == null) {
				availableSlots = new ArrayList<>();
			}
			avSlot.setDate(this);
			availableSlots.add(avSlot);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DateSlots other = (DateSlots) obj;
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
		return true;
	}

}
