package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;



/**
 * Testing the stat, container method for hashmap but an entity
 * @author Henry wang
 */
public class StatTest {

	/**
	 * Testing most popular ordered products
	 */
	@Test
	void testMostPopular() {
	
		ArrayList<Produce> split = Event.splitProducts("tomatoe, lettuce", "100, 100");
		
		Event e = new Event("1/1/24", "1/2/24", "Chapel Hill", "Fun times!", split);
		
		Produce p1 = new Produce((float) 5, "lettuce", 15);
		Produce p2 = new Produce((float) 5, "onion", 25);

		Order.makeOrder(e, p1, 3, "Happy customer");
		
		Order.makeOrder(e, p2, 5, "Happy customer");
		
		Order.makeOrder(e, p1, 6, "Happy customer");
		
		Stat s = new Stat();
		assertEquals(9, s.getPop().get(p1));
		assertEquals(5, s.getPop().get(p2));
		
		
	}

}
