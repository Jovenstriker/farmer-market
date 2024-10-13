package com.example.demo.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * Testing the user instance
 */
public class UserName {
	/**
	 * Testing valid users
	 */
	@Test
	void testValid() {
		User u = new User("Happy", "123 Little Valley", "WeChat");
		assertEquals("Happy", u.getName());
		assertEquals("123 Little Valley", u.getAddress());
		assertEquals("WeChat", u.getWechat());

	}
}
