package com.revature.functional.designpatterns.fluent;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<String> cart = new ArrayList<>();
	private String address = "";
	
	
	public void add(String item) {
		cart.add(item);
		System.out.println(item + " added to cart.");
	}
	
	
	public void deliverAt(String location) {
		this.address = location;
		System.out.println(location + " has been set as delivery address.");
	}
	
	public void place() {
		System.out.println("Order placed!");
		System.out.println(this.cart.size() + " items ordered to be shipped in 3 days.");
	}

}
