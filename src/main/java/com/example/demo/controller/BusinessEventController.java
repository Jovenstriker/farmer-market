package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Business;
import com.example.demo.model.Event;
import com.example.demo.model.Produce;
import com.example.demo.repository.BusinessEventRepository;


@RestController
public class BusinessEventController {

	
	   @Autowired
	   private BusinessEventRepository businessEventRepository;

	    @PostMapping("/event")
	    public Event setEvent(@RequestParam String pickupSchedule, @RequestParam String deliverySchedule, @RequestParam String address, @RequestParam String productName, @RequestParam String quantity, @RequestParam String description) {
	    	
	    	Business b = Business.getInstance();
	    	ArrayList<Produce> produce = Event.splitProducts(productName, quantity);
	    	Event e = new Event(pickupSchedule, deliverySchedule, address, description, produce);
	    	b.addEvent(e);
	    	return businessEventRepository.save(e);
	    }


	    @GetMapping("/event")
	    public List<Event> getEvent() {
	        return businessEventRepository.findAll();
	    }


}
