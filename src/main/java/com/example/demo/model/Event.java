package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class for events, basically dates to pick up from
 * The business can set these up
 * @author Henry Wang
 */
@Entity
public class Event implements Serializable{


    private static final long serialVersionUID = 1L;

	/**
     * Id for each event
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * Date of event
	 */
	private String pickupDate;
	
	/**
	 * Start time of event
	 */
	private String deliveryDate;
	
	
	/**
	 * Location of event
	 */
	private String location;
	
	/**
	 * Description of the event
	 */
	private String description;
	
	/**
	 * Array list of the available inventory
	 */
	private ArrayList<Produce> inventory;
	
	/**
	 * Constructor to set up an event
	 * @param pickupDate The pick up date
	 * @param deliveryDate The delivery date
	 * @param location The location
	 * @param description The description of the event
	 * @param inventory The inventory of the event
	 */
	public Event(String pickupDate, String deliveryDate, String location, String description, ArrayList<Produce> inventory) {
		this.pickupDate = pickupDate;
		this.deliveryDate = deliveryDate;
		this.location = location;
		this.description = description;
		this.inventory = inventory;
	}

	/**
	 * Empty constructor
	 */
	public Event() {
		
	}
	/**
	 * Accessor method for pickup date
	 * @return the pickupDate
	 */
	public String getPickupDate() {
		return pickupDate;
	}



	/**
	 * Accessor method for delivery date
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}




	/**
	 * Accessor method for location
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Accessor method for inventory
	 * @return the inventory
	 */
	public ArrayList<Produce> getInventory() {
		return inventory;
	}


	/**
	 * Accessor method for description
	 * @return The description of event
	 */
	public String getDescription() {
		return description;
	}
	


	
	/**
	 * Helper method to split a string into an array list seperated by comma
	 * Used to handle inputs "onion, lettuce" as array
	 * @param list String representation of list
	 * @return Array list representation
	 */
    private static ArrayList<String> splitString(String list){
    	Scanner scanner = new Scanner(list);
    	scanner.useDelimiter(",\\s*");

        ArrayList<String> seperate = new ArrayList<String>();
        while (scanner.hasNext()) {
        	seperate.add(scanner.next());
        }
        scanner.close();
    	return seperate;
    }
    
    /**
     * Helper method to make an arraylist of products instead of strings
     * @param productNames The names of the products
     * @param quantity The corresponding quantities of 
     * @return Array list of produce
     */
    public static ArrayList<Produce> splitProducts(String productNames, String quantity){
    	ArrayList<String> names = splitString(productNames);
    	ArrayList<String> quantities = splitString(quantity);    	
    	ArrayList<Produce> stock = Business.getInstance().getStock();

    	
    	HashMap<String, Produce> stockNames = new HashMap<String, Produce>();
    	for (int i = 0; i < stock.size(); i++) {
    		stockNames.put(stock.get(i).getName(), stock.get(i));
    	}
    	

    	ArrayList<Produce> produces = new ArrayList<Produce>();
    	for (int i = 0; i < names.size(); i++) {
    		String name = names.get(i);
    		if (stockNames.keySet().contains(name)) {

    			float oldPrice = stockNames.get(name).getPricePerQuantity();
        		Produce produce = new Produce(oldPrice, name, Integer.parseInt(quantities.get(i)));
        		produces.add(produce);
    		}
    	}
    	return produces;
    }
    
	
}
