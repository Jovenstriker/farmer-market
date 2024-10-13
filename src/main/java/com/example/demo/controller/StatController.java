package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stat;
import com.example.demo.repository.StatRepository;
@RestController
public class StatController {

	   @Autowired
	   private StatRepository statRepository;

	    @GetMapping("/stat")
	    public List<Stat> getProduce() {
	    	Stat s = new Stat();
	    	statRepository.save(s);
	    	return statRepository.findAll();
	    }
}
