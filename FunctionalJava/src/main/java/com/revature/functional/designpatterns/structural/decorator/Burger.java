package com.revature.functional.designpatterns.structural.decorator;

public class Burger {
	
	private String burgerType;
	
	// for creating a Burger with no Decoration
	public Burger() {
		this.burgerType = "";
	}
	
	// private to add decoration
	private Burger(String burgerType) {
		this.burgerType = burgerType;
	}
	
	public Burger addVeggies() {
		System.out.println("Adding Veggies to the burger");
		return new Burger(this.burgerType+=" Veggie"); // not modifying the instance state in Functional Programming
	}
	
	public Burger addCheese() {
		System.out.println("Adding cheese to the burger.");
		return new Burger(this.burgerType += " Cheese");
	}
	
	@Override
	public String toString() {
		return String.format("%s", burgerType + " burger");
	}

}
