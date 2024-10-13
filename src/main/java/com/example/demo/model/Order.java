package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class for orders
 * User puts in orders of selected product and quantity
 * @author Henry Wang
 */
@Entity
public class Order {
	
	/**
	 * Id of order
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * User who placed the order
     */
    private String user;
    
	/**
	 * The produce to be ordered
	 */
	private Produce selectedProduce;
	
	
	/**
	 * Amount of produce to be ordered
	 */
	private int quantity;
	
	/**
	 * Where you will pick up the order
	 */
	private Event event;
		
	
	/**
	 * Price of the order
	 * Quantity times price
	 */
	private float floatPrice;
	
	/**
	 * Constructor to set the order
	 * @param user User that puts in the order
	 * @param produce Produce to be ordered
	 * @param quantity Quantity of produce to be ordered
	 * @param event Event to where to pickup
	 */
	public Order(String user, Produce produce, int quantity, Event event) {
		this.user = user;
		this.selectedProduce = produce;
		if (quantity > selectedProduce.getStock()) {
			throw new IllegalArgumentException("Quantity requested greater than stock");
		}
		selectedProduce.setStock(selectedProduce.getStock() - quantity);

		this.quantity = quantity;
		
		this.event = event;
		
		this.floatPrice = selectedProduce.getPricePerQuantity() * quantity;

	}

	/**
	 * Empty constructor
	 */
	public Order() {
		
	}
	/**
	 * Accessor method for user
	 * @return the user
	 */
	public String getUser() {
		return user;
	}



	/**
	 * Accessor method for quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * Accessor method for event
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}



	/**
	 * Gets the price of the order
	 * @return the floatPrice
	 */
	public float getFloatPrice() {
		return floatPrice;
	}




	/**
	 * Accessor method for selected produce
	 * @return the selectedProduce
	 */
	public Produce getSelectedProduce() {
		return selectedProduce;
	}

	
	/**
	 * Makes a order from primitive parameters
	 * @param event Event to be picked up
	 * @param produce Produce to be ordered
	 * @param quantity Quantity of produce ordered
	 * @param name Name of user
	 * @return Order consisting of parameter information
	 */
	public static Order makeOrder(Event event, Produce produce, int quantity, String name) {
		Order order = new Order(name, produce, quantity, event);
		Business.getInstance().receiveOrder(order);
		return order;
	}
	
}
