package com.revature.finitevsinfinite;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BoundedStreams {
	
	// Bounded or Finite Streams

	public static void main(String[] args) {
		
		
		// .stream() on collections
		List<Integer> list = List.of(1, 4, 5, 6, 7, 8);
		
		Stream<Integer> streamIntegers = list.stream();
		
		// but what about a map? with key-value pairs
		// get key set, entry set or values and then stream
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");
		
		Stream<Entry<Integer, String>> mapStream = map.entrySet().stream();
		
		// if we only wanted the values...
		Stream<String> mapValues = map.values().stream();
		
		Stream<Integer> mapKeys = map.keySet().stream();
		
		
		// Stream.of() 
		
		Stream<String> strings = Stream.of("Hello", "Hola", "Bonjour", "Namaste");
		
		
		// Arrays.stream() - will return either an Object Stream or a Primitive Stream depending on the values in the existing array
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
		
		Stream<Integer> intStream = Arrays.stream(intArray);
		
		int[] intArr = {4, 5, 6, 7, 8, 9};
		IntStream intStr2 = Arrays.stream(intArr); 
		
		
		
		// Builder Pattern Stream.builder() - gives a bit more flexibility
		Builder<Integer> builder = Stream.builder();
		builder.add(1);
		
		// more code with conditions
		builder.add(4);
		 
		// when we're ready for the Stream
		 
		Stream<Integer> anotherIntStream = builder.build();
		
	}
	
}
