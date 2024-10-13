package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Testing the business instance class
 * @author Henry Wang
 */
class BusinessTest {

	/**
	 * Business instance
	 */
	private Business b;
	
	/**
	 * Sets up the singleton
	 */
	@BeforeEach
	void setup() {
		b = Business.getInstance();
		b.clear();
		
	}
	
	/**
	 * Testing adding produce from primitives
	 */
	@Test
	void testAddProduce() {
		b.addProduce("tomato", (float) 4.5, 5);
		b.addProduce("lettuce", (float) 2.99, 10);
		
		assertEquals("tomato", b.getStock().get(0).getName());
		assertEquals("lettuce", b.getStock().get(1).getName());
		assertEquals((float) 4.5, b.getStock().get(0).getPricePerQuantity());
		assertEquals(5, b.getStock().get(0).getStock());
		assertEquals((float) 2.99, b.getStock().get(1).getPricePerQuantity());
		assertEquals(10, b.getStock().get(1).getStock());
		assertEquals(2, b.getStock().size());

	}
	
	/**
	 * Testing most popular ordered products
	 */
	@Test
	void testMostPopular() {
		ArrayList<Produce> split = Event.splitProducts("tomato, lettuce", "100, 100");
		
		Event e = new Event("1/1/24", "1/2/24", "Chapel Hill", "Fun times!", split);
		
		Produce p1 = new Produce((float) 5, "lettuce", 15);
		Produce p2 = new Produce((float) 5, "onion", 25);

		Order.makeOrder(e, p1, 3, "Happy customer");
		
		Order.makeOrder(e, p2, 5, "Happy customer");
		
		Order.makeOrder(e, p1, 6, "Happy customer");
		
		HashMap<String, Integer> pop = b.getPopular();
		
		assertEquals(9, pop.get(p1.getName()));
		assertEquals(5, pop.get(p2.getName()));

		
		
	}

	
}
