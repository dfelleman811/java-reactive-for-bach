package com.revature.functional.designpatterns.creational.factory;

import java.util.function.Supplier;

public class FlooringFactory {
	
	public static Flooring getFlooring(int minTemp, int maxTemp) {
		
		Supplier<Flooring> flooring;
		
		if (minTemp <= 5 && maxTemp <=20) {
			flooring = () -> new WoodenFlooring();
		} 
		else if (minTemp <= 15 && maxTemp >= 45) { 
			flooring = () -> new CorkFlooring();
		} else {
			flooring = () -> new ConcreteFlooring();
		}
		return flooring.get();
	}

}
