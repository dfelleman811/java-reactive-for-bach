package com.revature.functional.basics;

public class PureFunction {
	
	// Takes two args a and b and returns the sum. the return value only depends on input params
	// has no side effects - does not modify any state outside the function anywhere. it'ns ot modifying a and b - just returning the sum
	public int sum(int a, int b) {
		return a + b;
	}

}
