package com.example.demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;



/**
 * Testing the reviews from user to business
 * @author Henry Wang
 */
public class ReviewTest {
	/**
	 * Testing valid reviews
	 */
	@Test
	void testValid() {
		Review r = new Review("Happy", 2, "Good");
		assertEquals("Happy", r.getName());
		assertEquals("Good", r.getComment());
		assertEquals(2, r.getRating());
	}
	
	/**
	 * Testing invalid reviews
	 */
	@Test
	void testInvalid() {
		assertThrows(IllegalArgumentException.class, () -> new Review("Happy", 0, "Good"));
		assertThrows(IllegalArgumentException.class, () -> new Review("Happy", 7, "Good"));

	}
}
