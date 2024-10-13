package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Produce class
 * Represents each vegetable with price, name, and stock available
 * @author Henry Wang
 */
@Entity
public class Produce implements Serializable {
	
	/**
	 * Serial id
	 */
    private static final long serialVersionUID = 1L;

    /**
     * Id of each produce
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	/**
	 * Unit price of produce
	 */
	private float pricePerQuantity;
	
	/**
	 * Name of produce
	 */
	private String name;
		
	/**
	 * Available stock of produce
	 */
	private int stock;
	
	/**
	 * Image url
	 */
	private String imageUrl;
	
	/**
	 * Constructor to set the produce
	 * @param price Unit price of produce
	 * @param name Name of produce
	 * @param stock Available stock left
	 * @param imageUrl Image of produce
	 */
	public Produce(float price, String name, int stock, String imageUrl) {
		setPricePerQuantity(price);
		setName(name);
		setStock(stock);
		setImageUrl(imageUrl);
	}
	
	/**
	 * Empty constructor
	 */
	public Produce() {
		
	}
	
	/**
	 * Constructor without image url
	 * @param price Unit price of produce
	 * @param name Name of produce
	 * @param stock Stock left of produce
	 */
	public Produce(float price, String name, int stock) {
		this(price, name, stock, null);
	}
	
	
	/**
	 * Accessor method for price per quantity
	 * @return the pricePerQuantity
	 */
	public float getPricePerQuantity() {
		return pricePerQuantity;
	}

	/**
	 * Settor method for unit price
	 * @param pricePerQuantity the pricePerQuantity to set
	 * @throws IllegalArgumentException if price is negative
	 */
	public void setPricePerQuantity(float pricePerQuantity) {
		if (pricePerQuantity < 0) {
			throw new IllegalArgumentException("Price can't be negative!");
		}
		
		this.pricePerQuantity = pricePerQuantity;
	}

	/**
	 * Accessor method for name
	 * @return the name of produce
	 */
	public String getName() {
		return name;
	}

	/**
	 * Settor method for name
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name.equals(null) || name.equals("")) {
			throw new IllegalArgumentException("Name can't be empty!");
		}
		this.name = name;
	}


	/**
	 * Accessor method for stock
	 * @return the stock of produce left
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Settor method for stock
	 * @param stock the stock to set
	 * @throws IllegalArgumentException if negative stock
	 */
	public void setStock(int stock) {
		if (stock < 0) {
			throw new IllegalArgumentException("Can't have negative stock!");
		}
		this.stock = stock;
	}
	
	/**
	 * Accessor method for image url
	 * @return The image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Settor method for image url
	 * @param imageUrl Url of produce image
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
