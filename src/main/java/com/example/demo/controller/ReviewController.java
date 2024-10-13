package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@RestController
public class ReviewController {

	   @Autowired
	   private ReviewRepository reviewRepository;

	    @PostMapping("/review")
	    public Review putReview(@RequestParam String name, @RequestParam int rating, @RequestParam String description) {
	    	Review review = new Review(name, rating, description);
	    	return reviewRepository.save(review);
	    }

	    @GetMapping("/review")
	    public List<Review> getProduce() {
	        return reviewRepository.findAll();
	    }
}
