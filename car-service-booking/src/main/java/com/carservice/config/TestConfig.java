package com.carservice.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carservice.domain.model.AvailableSlots;
import com.carservice.domain.model.DateSlots;
import com.carservice.repository.AvailableSlotsRep;
import com.carservice.repository.DateSlotsRep;

//@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private AvailableSlotsRep availableSlotsRep;

	@Autowired
	private DateSlotsRep dateSlotsRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		DateSlots dateSlots1 = new DateSlots(new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-21"), null);
		DateSlots date1 = new DateSlots(dateSlots1.getDate(), null);
		
		DateSlots dateSlots2 = new DateSlots(new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-22"), null);
		DateSlots date2 = new DateSlots(dateSlots2.getDate(), null);
		
		DateSlots dateSlots3 = new DateSlots(new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-23"), null);
		DateSlots date3 = new DateSlots(dateSlots3.getDate(), null);
		
		AvailableSlots slot1 = new AvailableSlots(null, date1, "Rodrigo", "abc123abc@", "9am", true);
		AvailableSlots slot2 = new AvailableSlots(null, date1, "Pedro", "cba123abc@", "10am", true);
		AvailableSlots slot3 = new AvailableSlots(null, date1, "Gabriel", "dse123abc@", "11am", true);
		AvailableSlots slot7 = new AvailableSlots(null, date1, null, null, "1pm", false);
		AvailableSlots slot8 = new AvailableSlots(null, date1, null, null, "2pm", false);
		AvailableSlots slot9 = new AvailableSlots(null, date1, null, null, "3pm", false);
		AvailableSlots slot10 = new AvailableSlots(null, date1, null, null, "4pm", false);
		
		AvailableSlots slot4 = new AvailableSlots(null, date2, "Paola", "@dse123abc", "9am", true);
		
		AvailableSlots slot5 = new AvailableSlots(null, date3, "Guto", "#dse123abc", "1pm", false);
		AvailableSlots slot6 = new AvailableSlots(null, date3, "Maria", "ddse123abc", "2pm", false);
		
		dateSlotsRep.saveAll(Arrays.asList(date1,date2, date3));
		availableSlotsRep.saveAll(Arrays.asList(slot1,slot2,slot3,slot7, slot8, slot9, slot10, slot4, slot5, slot6));
		
		List<DateSlots> dates = dateSlotsRep.findByDate(dateSlots1.getDate());
		dates.forEach(d -> System.out.println(d.getDate()));

		List<AvailableSlots> avail = availableSlotsRep.findByDate(dates.get(0));
		avail.forEach(a -> available(a.getAvailable(), a));
		
	}
	
	public void available(boolean aval,AvailableSlots a) {
		if(aval == false) {
			System.out.println(a.getSlot());
		}
	}
	
}
