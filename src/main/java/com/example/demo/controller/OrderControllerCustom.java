package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Event;
import com.example.demo.model.Produce;

public class OrderControllerCustom {
	private String name;
	private Event event;
	private Produce produce;
	private int quantity;
	
	public OrderControllerCustom(String name, Event event, Produce product, int quantity) {
		setName(name);
		setEvent(event);
		setProduce(produce);
		setQuantity(quantity);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}
	/**
	 * @return the produce
	 */
	public Produce getProduce() {
		return produce;
	}
	/**
	 * @param produce the produce to set
	 */
	public void setProduce(Produce produce) {
		this.produce = produce;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
