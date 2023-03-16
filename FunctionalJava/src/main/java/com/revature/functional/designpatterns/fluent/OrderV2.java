package com.revature.functional.designpatterns.fluent;

import java.util.ArrayList;
import java.util.List;

public class OrderV2 {
	
	private List<String> cart = new ArrayList<>();
	private String address = "";
	
	public OrderV2() {}
	
	public OrderV2(List<String> cart, String address) {
		this.cart = cart;
		this.address = address;
	}
	
	
	public OrderV2 add(String item) {
		cart.add(item);
		System.out.println(item + " added to cart.");
		return new OrderV2(cart, address);
	}
	
	
	public OrderV2 deliverAt(String location) {
		this.address = location;
		System.out.println(location + " has been set as delivery address.");
		return new OrderV2(cart, address);
	}
	
	public void place() {
		System.out.println("Order placed!");
		System.out.println(this.cart.size() + " items ordered to be shipped in 3 days.");
	}

}
