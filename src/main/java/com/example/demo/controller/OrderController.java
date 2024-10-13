package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Business;
import com.example.demo.model.Event;
import com.example.demo.model.Order;
import com.example.demo.model.Produce;import com.example.demo.repository.OrderRepository;

@RestController
public class OrderController {
	
   @Autowired
   private OrderRepository orderRepository;

    @PostMapping("/orders")
    public Order putOrder(@RequestBody OrderControllerCustom o) {
    	String name = o.getName();
    	Event event = o.getEvent();
    	Produce produce = o.getProduce();
    	int quantity = o.getQuantity();
    	Order order1 = Order.makeOrder(event, produce, quantity, name);
    	Business.getInstance().receiveOrder(order1);
    	return orderRepository.save(order1);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

}
