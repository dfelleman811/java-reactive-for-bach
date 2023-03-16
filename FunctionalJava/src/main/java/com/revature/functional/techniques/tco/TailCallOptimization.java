package com.revature.functional.techniques.tco;

public class TailCallOptimization {

	public static void main(String[] args) {
		
		System.out.println(reFact(4));
		
	}
	
	// factorial - using regularly recursive call
	public static long reFact(int n) {
		
		// when to stop?
		if (n <=1)
			return 1;
		else
			return n * reFact(n-1);
		
	}
	
	// here two params n = number to calculate the factorial of, a is the accumulator to keep track of the product
	public static long tailReFact(int n, int a) {
		
		if (n <= 1) 
			return a;
		else
			// a will be 1 always at the beginning
			return tailReFact(n-1, n *a);
	}
	
}
