package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.example.demo.model.Business;
import com.example.demo.model.Event;
import com.example.demo.model.Order;
import com.example.demo.model.Produce;
import com.example.demo.model.Review;
import com.example.demo.model.User;

public class DemoUI {
	/**
	 * Ui walkthrough of our project
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		//Creating instance of the business
		Business b = Business.getInstance();
		
		
		
		//Creating the produce to be sold by the business
		Produce tomato = b.addProduce("tomato", (float) 1.99, 100);
		Produce lettuce = b.addProduce("lettuce", (float) 2.99, 100);
		Produce watermelon = b.addProduce("watermelon", (float) 3.99, 100);
		Produce apple = b.addProduce("apple", (float) 4.99, 100);
		
		
		
		//Creating the eager customers
		User u1 = new User("Henry Wang", "123 Happy Farm", "WeChat1");
		User u2 = new User("Michelle Lan", "321 Unhappy Farm", "WeChat2");
		User u3 = new User("Wesley Li", "213 Indifferent Farm", "WeChat3");
		User u4 = new User("Mithun Dhanasuthan", "312 Calm Farm", "WeChat4");

		
		
		//Creating the inventory for first event
		ArrayList<Produce> event1Inventory = new ArrayList<Produce>();
		event1Inventory.add(tomato);
		event1Inventory.add(lettuce);
		event1Inventory.add(watermelon);
		event1Inventory.add(apple);
		
		
		scanner.nextLine();
		
		
		//First event
		Event event1 = new Event("8/3/2024", "8/3/2024", "here", "First event", event1Inventory);
		
		
		
		//Henry is buying 98 apples from event 1
		Order order1 = Order.makeOrder(event1, apple, 98, u1.getName());
		
		
		
		//Total cost is $489.02
		System.out.println("Total price is $" +order1.getFloatPrice());
		
		
		
		//Henry is trying to buy 3 more apples but since
		//only 100 started, business ran out of stock
		scanner.nextLine();
		try {
			Order.makeOrder(event1, apple, 3, u1.getName());
		} catch (Exception e) {
			System.out.println("Tried to buy 3 more apples but ran out of apples!");
		}
		
		
		scanner.nextLine();

		
		//The business added more apples!
		apple = b.addProduce("apple", (float) 3.99, 150);
		
		//Henry can now order a lot more apples!
		Order.makeOrder(event1, apple, 107, u1.getName());
		
		
		//People try different stuff
		Order.makeOrder(event1, tomato, 37, u2.getName());
		Order.makeOrder(event1, lettuce, 28, u3.getName());
		Order.makeOrder(event1, watermelon, 5, u4.getName());
		Order.makeOrder(event1, lettuce, 14, u4.getName());
		Order.makeOrder(event1, watermelon, 2, u1.getName());

		
		//Business can see all its orders
		
		System.out.println("Order list");
		System.out.println(seeOrders(b.getOrders()));
		
		
		scanner.nextLine();

		//Business can see stats and most popular orders
		
		
		System.out.println(seePopular(b.getPopular()));
		
		
		
		//People can write reviews too!
		Review.writeRating(u1.getName(), 2, "Not enough apples");
		Review.writeRating(u2.getName(), 2, ":(");
		Review.writeRating(u3.getName(), 3, "Its... okay");

		scanner.nextLine();

		
		System.out.println(seeReviews(b.getReviews()));
		
		
		scanner.close();
		
		
		
		
		
	}
	
	/**
	 * Helper method to see orders
	 * @param orders Arraylist of orders
	 * @return String representation to be printed out
	 */
	private static String seeOrders(ArrayList<Order> orders) {
		StringBuilder sb =  new StringBuilder();
		sb.append("Produce, Quantity, Price, Customer\n");
		
		for (Order o : orders) {
			sb.append(o.getSelectedProduce().getName());
			sb.append(", ").append(o.getQuantity());
			sb.append(", ").append(o.getFloatPrice());
			sb.append(", ").append(o.getUser());
			sb.append("\n");

		}
		return sb.toString();
	}

	/**
	 * Helper method to see most popular orders
	 * @param orders Orders to get info from
	 * @return String representation to be printed out
	 */
	private static HashMap<String, Integer> seePopular(HashMap<String, Integer> orders) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		ArrayList<Integer> quantityBought = new ArrayList<Integer>();
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
        	quantityBought.add(entry.getValue());
        }
        Collections.sort(quantityBought); 
        
        for (int num : quantityBought) {
            for (Entry<String, Integer> entry : orders.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
	}
	
	
	/**
	 * Helper method to see reviews
	 * @param reviews Reviews to get info from
	 * @return String representation to be printed out
	 */
	private static String seeReviews(ArrayList<Review> reviews) {
		StringBuilder sb =  new StringBuilder();
		sb.append("Name, Rating, Comment\n");
		
		for (Review o : reviews) {
			sb.append(o.getName());
			sb.append(", ").append(o.getRating());
			sb.append(", ").append(o.getComment());
			sb.append("\n");

		}
		return sb.toString();
	}
	
}
