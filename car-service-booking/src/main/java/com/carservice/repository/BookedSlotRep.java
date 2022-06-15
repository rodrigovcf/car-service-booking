package com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carservice.domain.model.BookedSlot;

public interface BookedSlotRep extends JpaRepository<BookedSlot, Long>{
	

}
