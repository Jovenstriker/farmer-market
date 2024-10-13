package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Business;
import com.example.demo.model.Produce;
import com.example.demo.repository.ProduceRepository;

@RestController
public class ProduceController {
	   @Autowired
	   private ProduceRepository produceRepository;

//	   @PostMapping("/produce")
//	   public Produce putProduce(@RequestParam(value = "name") String name, @RequestParam(value = "price") String price, @RequestParam(value = "quantity") String quantity, @RequestParam(value = "imageURL") String imageURL) {
//	    	
	   @PostMapping("/produce")
	   public Produce putProduce(@RequestBody ProduceControllerCustom p) {
	    	String price = p.getPrice();
	    	String quantity = p.getQuantity();
	    	String name = p.getName();
	    	String imageURL = p.getImageURL();
	    	Float floatPrice;
	    	Integer intQuantity;
	    	if (price == null) {
	    		floatPrice = (float) 1;
	    	} else {
		    	floatPrice = Float.parseFloat(price);
	    	}
	    	if (quantity == null) {
	    		intQuantity = 5;
	    	} else {
		    	intQuantity = Integer.parseInt(quantity);
	    	}

	    	Produce produce = new Produce(floatPrice, name, intQuantity, imageURL);
	    	Business.getInstance().addProduce(produce);
	    	return produceRepository.save(produce);
	    }

	    @GetMapping("/produce")
	    public List<Produce> getProduce() {
	        return produceRepository.findAll();
	    }
}
