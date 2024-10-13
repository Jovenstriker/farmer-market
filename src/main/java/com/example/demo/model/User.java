package com.example.demo.model;



/**
 * Class for each user
 * @author Henry Wang
 */
public class User {
	/**
	 * Name of user
	 */
	private String name;
	
	/**
	 * Address of user
	 */
	private String address;
	
	/**
	 * WeChat of user
	 */
	private String wechat;
	
	/**
	 * Constructor to create a user
	 * @param name Name of user
	 * @param address Address of user
	 * @param wechat WeChat of user
	 */
	public User(String name, String address, String wechat) {
		setName(name);
		setAddress(address);
		setWechat(wechat);
	}

	
	/**
	 * Accessor method for name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Settor method for name
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method for address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Settor method for address
	 * @param address the address to set
	 */
	private void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Accessor method for wechat
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}

	/**
	 * Settor method for wechat
	 * @param wechat the wechat to set
	 */
	private void setWechat(String wechat) {
		this.wechat = wechat;
	}



	
	
	
}
