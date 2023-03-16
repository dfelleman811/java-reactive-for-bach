package com.revature.functional.basics;

public class ReferentialTransparency {
	
	public static void main(String[] args) {
		
		int result = add(2, multiply(2,4));
		System.out.println(result);
		
		int result2 = add(2, 8);
		int result3 = add(2, multiply(2, multiply(2,2)));
		System.out.println(result2);
		System.out.println(result3);
		
	}

	public static int add(int a, int b) {
		return a + b;
	}
	// this multiply is referentially transparent
	public static int multiply(int a, int b) {
		return a * b;
	}
	// this is not - since replacing it will change the result, we won't have the print to console
	public static int multiply2(int a, int b) {
		System.out.println("Multiplying a and b: " + a + ',' + b);
		return a * b;
	}
	
}

// Another example of multiply not being referentially transparent
class Demo {
	
	public static void main(String[] args) {
	
		// because if we switch out multiply here for it's returned value, we lose the log
		int result = add(6, multiply(3,4));
		System.out.println(result);
		
		int result2 = add(6, 12);
		System.out.println(result2);
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int multiply(int a, int b) {
		log(String.format("Returning %s as the result of %s * %s", a*b, a, b));
		return a*b;
	}
	
	
	public static void log(String m) {
		System.out.println(m);
	}
	
}