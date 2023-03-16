package com.revature.functional.designpatterns.creational.factory;

public class FactoryPattern {
	
	// Scenario - design the flooring that we can use in any housing unit
	// criteria is the climate / temp for location
	// i.e. hot climate -> concrete etc.
	
	public static void main(String[] args) {
		
		Flooring flooring = FlooringFactory.getFlooring(-1, 18);
		flooring.installation();
		
		
		Flooring flooring1 = FlooringFactory.getFlooring(13, 46);
		flooring1.installation();
		
		
		Flooring flooring2 = FlooringFactory.getFlooring(30, 90);
		flooring2.installation();
	}

}
