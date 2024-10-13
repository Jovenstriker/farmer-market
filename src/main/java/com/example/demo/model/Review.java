package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The review that the user can leave for business owner to see
 * @author Henry Wang
 */
@Entity
public class Review implements Serializable{

	/**
	 * Serial id
	 */
    private static final long serialVersionUID = 1L;


    /**
     * Id of review
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Customer name
     */
	private String name;
	
	/**
	 * Rating from 1 to 5
	 */
	private int rating;
	
	/**
	 * Description of review
	 */
	private String comment;

	/**
	 * Constructor to make the review
	 * @param name Name of customer
	 * @param rating Rating of satisfaction
	 * @param comment Description
	 */
	public Review(String name, int rating, String comment) {
		setName(name);
		setRating(rating);
		setComment(comment);
	}
	/**
	 * Empty constructor
	 */
	public Review() {
		
	}
	
	/**
	 * Accessor method of name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Settor method of name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method of name
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Settor method of name
	 * @param rating the rating to set
	 * @throws IllegalArgumentException if rating not between 1 and 5
	 */
	public void setRating(int rating) {
		if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Rating has to be between 1 and 5!");
		}
		this.rating = rating;
	}

	/**
	 * Accessor method for comment
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Settor method for comment
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public static Review writeRating(String name, int rating, String comment) {
		Review r = new Review(name, rating, comment);
		Business.getInstance().addReview(r);
		return r;
	}
	
	
	
	
}
