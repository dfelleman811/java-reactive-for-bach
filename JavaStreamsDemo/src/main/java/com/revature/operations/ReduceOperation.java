package com.revature.operations;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceOperation {
	
	// we may need to perform some operation where the stream results in a single value 
	// like (product, sum, max, min, etc)
	// we use reduce() for that - It's a repetitive process of combining all the elements
	// reduce takes two args - first is the identity value and the second is the BinaryOperator
	public static void main(String[] args) {
		
		
		Integer sum = Stream.of(1, 2, 34, 45, 56, 67, 78, 89)
							.reduce(0, (a,b)->a+b); 				// identity is a value that has no effect when used in an operation (i.e. for sum use 0, for multiplication use 1

		System.out.println(sum);

		
		int product = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
			.reduce(1, (a,b) -> a * b);
		
		System.out.println(product);
	}
	
}
