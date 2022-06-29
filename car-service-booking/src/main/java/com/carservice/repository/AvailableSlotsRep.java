package com.carservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;

public interface AvailableSlotsRep extends JpaRepository<AvailableSlots, Long>{

	List<AvailableSlots> findByDate(DateSlots date);
	List<AvailableSlots> findBySlot(String slot);
	List<AvailableSlots> findByToken(String token);
	
	@Query(value = "SELECT * FROM tb_available_slots WHERE id_date = :idDate and slot = :slot", nativeQuery = true)
	AvailableSlots findSlotUpdate(Long idDate, @Param("slot") String slot);
		
}
