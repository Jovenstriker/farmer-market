package com.example.demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;


/**
 * Testing the produce
 * @author Henry Wang
 */
public class ProduceTest {
	/**
	 * Testing valid produce
	 */
	@Test
	void testConstructor() {
		Produce p = new Produce((float) 4.99, "onion", 10);
		assertEquals(4.99, p.getPricePerQuantity(), 0.0001);
		assertEquals("onion", p.getName());
		assertEquals(10, p.getStock());
		assertNull(p.getImageUrl());

	}
	/**
	 * Testing invalid produce
	 */
	@Test
	void testInvalid() {
		assertThrows(IllegalArgumentException.class, () -> new Produce((float) 4.99, "", 10));
		assertThrows(IllegalArgumentException.class, () -> new Produce((float) -1, "onion", 10));
		assertThrows(IllegalArgumentException.class, () -> new Produce((float) 4.99, "onion", -1));


	}
}
