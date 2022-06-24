package com.carservice.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carservice.domain.model.DateSlots;

public interface DateSlotsRep extends JpaRepository<DateSlots, Long>{

	List<DateSlots> findByDate(Date date);
	boolean existsByDate(Date date);
	
}
