package com.revature.functional.designpatterns.structural.decorator;

public class DecoratorPattern {
	
	public static void main(String[] args) {
		
		Burger myOrder = new BurgerShop(burger -> burger.addCheese())
				.use(
					new BurgerShop(burger -> burger.addVeggies())
						.use(
							new Burger()
							)
					);
		
		System.out.println("My Order: " + myOrder);
	}

}
