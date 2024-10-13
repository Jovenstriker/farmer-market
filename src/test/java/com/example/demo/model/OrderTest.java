package com.example.demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;



/**
 * Testing the order class, where user input orders
 */
public class OrderTest {
	/**
	 * Testing creating a order along with exception if order is too big
	 */
	@Test
	void testMakeOrder() {
		Business b = Business.getInstance();
		b.addProduce("tomatoe", (float) 1.99, 100);
		b.addProduce("lettuce", (float) 2.99, 100);
		b.addProduce("watermelon", (float) 3.99, 100);
		b.addProduce("apple", (float) 4.99, 100);

		ArrayList<Produce> split = Event.splitProducts("tomatoe, lettuce", "3, 4");
		
		Event e = new Event("1/1/24", "1/2/24", "Chapel Hill", "Fun times!", split);
		
		Produce p = new Produce((float) 5, "lettuce", 10);
		Order o = Order.makeOrder(e, p, 2, "Happy customer");
		assertEquals(8, p.getStock());
		
		assertThrows(IllegalArgumentException.class, () -> Order.makeOrder(e, p, 10, "Greedy customer"));
		
		assertEquals(e, o.getEvent());
		assertEquals(p, o.getSelectedProduce());
		assertEquals(2, o.getQuantity());
		assertEquals("Happy customer", o.getUser());

		assertEquals(10, o.getFloatPrice(), 0.0001);

	}
	
	
}
