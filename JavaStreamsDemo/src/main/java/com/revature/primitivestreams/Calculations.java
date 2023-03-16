package com.revature.primitivestreams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations {
	public static void main(String[] args) {
		
		// Useful methods for Numeric Streams (that don't exist for Object Streams)
		// IntStream
		
		
		// Sum - returns a sum of the type of stream (if stream is empty it will return 0)
		
		int sum = IntStream.of(1,2,3).sum();
		System.out.println(sum);
		
		
		// max - returns an Optional - but a Primitive Optional - if stream is empty it will return an empty optional
		OptionalInt maxOpt = IntStream.of(10, 20, 30).max();
		System.out.println(maxOpt.orElseGet(()->0));
		
		
		// min() - returns a primitive optional
		OptionalInt minOpt = IntStream.of(100,200,300,3,020,1).min();
		System.out.println(minOpt.getAsInt());
		
		// average() - also returns a primitive optional but specifical an OptionalDouble
		OptionalDouble avgOpt = IntStream.of(100,200,300,3,020,1).average();
		System.out.println(avgOpt.getAsDouble());
		
		//summaryStatistics - calculates max min avg and sum all at once and the count
		
		IntSummaryStatistics summaryStats = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.summaryStatistics();
		System.out.println(summaryStats);
		
		
	}
	
		

}
