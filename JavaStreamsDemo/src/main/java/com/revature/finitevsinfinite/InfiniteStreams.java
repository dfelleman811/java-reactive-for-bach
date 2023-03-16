package com.revature.finitevsinfinite;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
	
	// Infinite Sterams (unbounded) - elements are continually streamed - no end!
	
	public static void main(String[] args) {
		
		// first argument is the seed (starting point) and the second argument is a UnaryOperator
		
		Stream.iterate(0, i -> i+1);
		
		// works on primitive streams as well
		
		IntStream.iterate(5, i -> i-1)
			.limit(15) // because this stream is infinite we can use the limit() method to limit the number of elements
			.forEach(System.out::println);
		
		
		
		// generate() - takes a supplier
		// suitable for instance if you want a stream of random numbers
		
		Stream.generate(() -> "Hello")
			.limit(10)
			.forEach(System.out::println);
		
		Stream.generate(new Random() :: nextInt)
			.limit(25)
			.forEach(System.out::println);;
		
	}

}
