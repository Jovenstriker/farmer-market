package com.example.demo.model;

import java.util.HashMap;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Container class for displaying map of most popular products
 * @author Henry Wang
 */
@Entity
public class Stat {
	/**
	 * Id of stat
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * Map of most popular products by amount ordered
	 */
	private HashMap<String, Integer> pop;
	
	/**
	 * Constructor to get most popular from business
	 */
	public Stat() {
		setPop(Business.getInstance().getPopular());
	}

	/**
	 * Accessor method for map
	 * @return Map of most popular
	 */
	public HashMap<String, Integer> getPop() {
		return pop;
	}

	/**
	 * Settor method for popular
	 * @param pop Map to be set
	 */
	public void setPop(HashMap<String, Integer> pop) {
		this.pop = pop;
	}
	
}
