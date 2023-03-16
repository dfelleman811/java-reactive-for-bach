package com.revature.functional.designpatterns.fluent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FluentOrder {
	
	private List<String> cart = new ArrayList<>();
	private String address = "";
	
	public FluentOrder() {}
	
	public FluentOrder(List<String> cart, String address) {
		this.cart = cart;
		this.address = address;
	}
	
	
	public FluentOrder add(String item) {
		cart.add(item);
		System.out.println(item + " added to cart.");
		return new FluentOrder(this.cart, this.address);
	}
	
	
	public FluentOrder deliverAt(String location) {
		this.address = location;
		System.out.println(location + " has been set as delivery address.");
		return new FluentOrder(this.cart, this.address);
	}
	
	public static void place(Function<FluentOrder, FluentOrder> function) {
		
		FluentOrder order = new FluentOrder();
		
		order = function.apply(order);
		
		
		System.out.println("Order placed!");
		System.out.println(order.cart.size() + " items ordered to be shipped in 3 days to: " + order.address);
	}

}
