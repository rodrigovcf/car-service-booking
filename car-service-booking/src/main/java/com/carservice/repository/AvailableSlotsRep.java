package com.carservice.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;

public interface AvailableSlotsRep extends JpaRepository<AvailableSlots, Long>{

	List<AvailableSlots> findByDate(DateSlots date);
	List<AvailableSlots> findBySlot(String slot);
	List<AvailableSlots> findByToken(String token);
	
	@Query(value = "SELECT * FROM servicecar.tb_available_slots WHERE id_date = :idDate and slot = :slot", nativeQuery = true)
	AvailableSlots findSlotUpdate(Long idDate, @Param("slot") String slot);
	
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM servicecar.tb_available_slots WHERE token = :token", nativeQuery = true)
	void deleteByToken(@Param("token") String token);
	
}
