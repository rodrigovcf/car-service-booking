package com.carservice.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;
import com.carservice.repository.AvailableSlotsRep;
import com.carservice.repository.DateSlotsRep;

@Service
public class SlotsService {

	@Autowired
	private AvailableSlotsRep availableSlotsRep;

	@Autowired
	private DateSlotsRep dateSlotsRep;

	public List<AvailableSlots> loadSlots(String date) throws ParseException {

		DateSlots dateSlots = new DateSlots(new SimpleDateFormat("yyyy-MM-dd").parse(date), null);		
		
		if (!dateSlotsRep.existsByDate(dateSlots.getDate())) {
			dateFullFree(dateSlots.getDate());
		} 

		List<DateSlots> dates = dateSlotsRep.findByDate(dateSlots.getDate());
		List<AvailableSlots> avail = availableSlotsRep.findByDate(dates.get(0));
		List<AvailableSlots> availableSlots = new ArrayList<>();

		avail.forEach(a -> {
			if(Boolean.FALSE.equals(a.getAvailable()))
				availableSlots.add(a);
		});

		return availableSlots;
	}

	public void dateFullFree(Date dateSlot) {

		DateSlots date = new DateSlots(dateSlot, null);
		AvailableSlots slot1 = new AvailableSlots(null, date, null, null, "9am", false);
		AvailableSlots slot2 = new AvailableSlots(null, date, null, null, "10am", false);
		AvailableSlots slot3 = new AvailableSlots(null, date, null, null, "11am", false);
		AvailableSlots slot4 = new AvailableSlots(null, date, null, null, "1pm", false);
		AvailableSlots slot5 = new AvailableSlots(null, date, null, null, "2pm", false);
		AvailableSlots slot6 = new AvailableSlots(null, date, null, null, "3pm", false);
		AvailableSlots slot7 = new AvailableSlots(null, date, null, null, "4pm", false);

		dateSlotsRep.save(date);
		availableSlotsRep.saveAll(Arrays.asList(slot1,slot2,slot3,slot4, slot5, slot6, slot7));
	}
	
	public void freeSlot(String token) {
		List<AvailableSlots> slot = availableSlotsRep.findByToken(token);

		slot.get(0).setName(null);
		slot.get(0).setTokenNull();
		slot.get(0).setAvailable(false);

		availableSlotsRep.save(slot.get(0));
	}

}
