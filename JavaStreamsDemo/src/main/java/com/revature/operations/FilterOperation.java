package com.revature.operations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {
	
	// filter() is basically a functional version of an if statement.
	// it takes a Predicate<T> as an argument (which is a functional itnerface that has one abstract method test(T t) that takes an input and returns a boolean value
	
	public static void main(String[] args) {
		
		Stream.of(34, 234, 456, 23, 31, 345, 7) //  of() can be used to create a stream of any type of object
			.filter(e -> e%2 == 0)
			.forEach(System.out::println);
		
		// all Intermediate Operations are lazy!! The filters (or any part of the Stream pipeline) won't be applied until a Terminal Operation is invoked on the stream
		
		
		Stream<Integer> intStream = Stream.of(34, 234, 456, 23, 31, 345, 7) 
		.filter(e -> e%2 == 0)
		.peek(i -> System.out.println("Filtered Int: " + i));
		
		System.out.println("Filtering done!");
		
		collect(intStream);
	}

	private static void collect(Stream<Integer> intStream) {

		List<Integer> filtered = intStream.collect(Collectors.toList()); // Terminal Operations on a Stream Pipeline are Eager.
		System.out.println("Collectiong done!");
		filtered.forEach(System.out::println);
	}

}
