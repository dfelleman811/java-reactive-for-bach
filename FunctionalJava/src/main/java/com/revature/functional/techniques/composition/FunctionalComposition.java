package com.revature.functional.techniques.composition;

public class FunctionalComposition {
	
	public static void main(String[] args) {
		
		// implementation to compute the area of a square
		Function<Square, Integer> fun1 = s -> s.getArea();
		
		// takes area and returns the length
		Function<Integer, Double> fun2 = area -> Math.sqrt(area);
		
		// now another function - a composed function that will do both jobs
		Function<Square, Double> getSide = fun2.compose(fun1);
		
		
		Square s = new Square();
		s.setArea(100);
		
		Double side = getSide.apply(s);
		System.out.println(side);
	}

}
