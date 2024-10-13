package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;



/**
 * Testing the event class
 * @author Henry Wang
 */
class EventTest {

	/**
	 * Testing making events from string representation
	 */
	@Test
	void testSplitProducts() {
		Business b = Business.getInstance();
		b.addProduce("tomatoe", (float) 1.99, 100);
		b.addProduce("lettuce", (float) 2.99, 100);
		b.addProduce("watermelon", (float) 3.99, 100);
		b.addProduce("apple", (float) 4.99, 100);

		ArrayList<Produce> split = Event.splitProducts("watermelon, lettuce", "3, 4");
		
		assertEquals(2, split.size());
		
	}
	
	/**
	 * Testing the constructor of event
	 */
	@Test
	void testConstructor() {
		Business b = Business.getInstance();
		b.addProduce("tomatoe", (float) 1.99, 100);
		b.addProduce("lettuce", (float) 2.99, 100);
		b.addProduce("watermelon", (float) 3.99, 100);
		b.addProduce("apple", (float) 4.99, 100);

		ArrayList<Produce> split = Event.splitProducts("tomatoe, lettuce", "3, 4");
		
		Event e = new Event("1/1/24", "1/2/24", "Chapel Hill", "Fun times!", split);
		assertEquals("1/1/24", e.getPickupDate());
		assertEquals("1/2/24", e.getDeliveryDate());
		assertEquals("Chapel Hill", e.getLocation());
		assertEquals("Fun times!", e.getDescription());
		assertEquals(split, e.getInventory());		
	}
	
	

}
