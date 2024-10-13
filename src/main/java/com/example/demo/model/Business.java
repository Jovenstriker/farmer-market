package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton class for Business
 * Has information on stocks, orders, and events
 * @author Henry Wang
 */
public class Business extends User{


	/**
	 * List for inventory of available produce
	 */
	private ArrayList<Produce> stock;

	/**
	 * List of scheduled orders
	 */
	private ArrayList<Order> orders;
	
	/**
	 * List of events
	 */
	private ArrayList<Event> events;
	
	/**
	 * List of reviews
	 */
	private ArrayList<Review> reviews;
	
	/**
	 * Constructor to set up the business
	 * @param name Name of business
	 * @param address Address of business
	 * @param wechat WeChat of business
	 */
	public Business(String name, String address, String wechat) {
		super(name, address, wechat);
		clear();

	}
	
	/**
	 * Empty constructor
	 */
	public Business() {
		this(null, null, null);
	}
	
	
	/**
	 * Instance for singleton
	 */
	private static Business business = new Business();

	/**
	 * Gets instance of Business or creates if null
	 * @return Business to be accessed
	 */
	public static Business getInstance() {
		if (business == null) {
			business = new Business();
		}
		return business;
	}
	
	/**
	 * Add the produce to the inventory/stock
	 * @param produce
	 */
	public void addProduce(Produce produce) {
		stock.add(produce);
	}
	
	/**
	 * Add produce to stock using primitives
	 * @param name Name of produce
	 * @param price Price of produce
	 * @param stockOfProduce Available stock
	 * @return Created produce
	 */
	public Produce addProduce(String name, float price, int stockOfProduce) {
		Produce newProduce = new Produce(price, name, stockOfProduce);
		addProduce(newProduce);
		return newProduce;
	}

	/**
	 * Add the order to order list
	 * @param order Order to be added
	 */
	public void receiveOrder(Order order) {
		orders.add(order);
	}
	
	/**
	 * Add event to event list
	 * @param e
	 */
	public void addEvent(Event e) {
		events.add(e);
	}
	
	/**
	 * Accessor method for stock
	 * @return The stock of products
	 */
	public ArrayList<Produce> getStock(){
		return stock;
	}

	/**
	 * Get map of most popular produce by ordered
	 * @return Map of produce and amount ordered
	 */
	public HashMap<String, Integer> getPopular(){
		HashMap<String, Integer> mostOrdered = new HashMap<String, Integer>();
		
		for (Order o : orders) {
			Produce produce = o.getSelectedProduce();
			if (mostOrdered.get(produce.getName()) != null) {
				int previous = mostOrdered.get(produce.getName());
				mostOrdered.put(produce.getName(), previous + o.getQuantity());
			} else {
				mostOrdered.put(produce.getName(), o.getQuantity());
			}
		}
		
		return mostOrdered;
	}
	
	/**
	 * Add review to reviews
	 * @param r The review
	 */
	public void addReview(Review r) {
		reviews.add(r);
	}
	
	/**
	 * Get orders
	 * @return The orders
	 */
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	/**
	 * Gets reviews
	 * @return The reviews
	 */
	public ArrayList<Review> getReviews(){
		return reviews;
	}
	
	/**
	 * Clear out previous lists
	 */
	public void clear() {
		stock = new ArrayList<Produce>();
		orders = new ArrayList<Order>();
		events = new ArrayList<Event>();
		reviews = new ArrayList<Review>();
	}
	
	
}
