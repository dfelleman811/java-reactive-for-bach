package com.revature.functional.techniques.currying;

import java.util.function.Function;

public class Currying {
	
	public static void main(String[] args) {
		
		// define a function that takes one integer and returns a function
//		Function<Integer, Function<Integer, Integer>> fun1 = u -> {
//			
//			return v -> u + v;
//		};
//		
//		Function<Integer, Integer> fun2 = fun1.apply(1);
//		Integer sum = fun2.apply(2);
//		System.out.println(sum);
		
		// cleaner
//		Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;
//		
//		Integer sum = fun1.apply(1).apply(2);
//		System.out.println(sum);
		
		
		// by using currying you can fix some parameters
		//same as first...
		Function<Integer, Function<Integer, Integer>> fun1 = u -> {
			
			return v -> u + v;
		};
		
		Function<Integer, Integer> fun2 = fun1.apply(1); // this is now fixed (don't need to pass the same value again and again) 
		
		Integer sum = fun2.apply(2);
		
		Integer sum2 = fun2.apply(3);
		
		Integer sum3 = fun2.apply(6);
		
		System.out.println("Sum1: " + sum);
		System.out.println("Sum2: " + sum2);
		
		
		// Even more currying!!
		// 1 takes an int and returns a function
		// 2 takes an int and returns another function
		Function<Integer, Function<Integer, Function<Integer, Integer>>> lotsOfFun = u -> v -> w -> u + v + w;
		
		// here 5 is u
		Function<Integer, Function<Integer, Integer>> funFun1 = lotsOfFun.apply(5);
		
		// here 6 is v
		Function<Integer, Integer> funFun2 = funFun1.apply(6);
		
		//here 7 is w
		Integer funSum = funFun2.apply(7);
		
		System.out.println(funSum);
		
	}

}
