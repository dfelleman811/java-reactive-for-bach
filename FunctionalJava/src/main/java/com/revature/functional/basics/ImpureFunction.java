package com.revature.functional.basics;

public class ImpureFunction {
	
	
	// method add uses a member variable and modifies it's state - it has a side effect
	private int value = 0;
	
	public int add (int nextValue) {
		this.value += nextValue;
		return this.value;
	}

}
