package com.revature.functional.designpatterns.structural.decorator;

import java.util.function.Function;

/**
 * To add decorations - it's building the burgers
 * @author DanielFelleman
 *
 */
public class BurgerShop {
	
	Function<Burger, Burger> decoration;
	
	// constructor to tell which decorator to use
		public BurgerShop(Function<Burger, Burger> decoration) {
			this.decoration = decoration;
		}
	
	// method to apply decorations 
	public Burger use(Burger baseBurger) {
		System.out.println("Base burger: " + baseBurger);
		return decoration.apply(baseBurger);
	}
	
	

}
