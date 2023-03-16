package com.revature.primitivestreams;

import com.revature.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {
	
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("The Sword of Shannara", "Terry Brooks", "Fantasy", 3.76));
		books.add(new Book("Neverwhere", "Neil Gaiman", "Fantasy", 4.17));
		books.add(new Book("The Shining", "Stephen King", "Horror", 4.25));
		books.add(new Book("Reprieve", "James Han Mattson", "Horror", 3.45));
		books.add(new Book("Mexican Gothic", "Silvia Moreno-Garcia", "Horror", 3.69));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.27));
		
		
		OptionalDouble average = books.stream()
			.map(book -> book.getRating())
			.mapToDouble(rating -> rating) // we need to convert this to a DoubleStream in order to invoke .average() - a Stream of primitive doubles - not Stream<Double>
			.average(); // average returns an optional
		
		//System.out.println(average.getAsDouble());
		
		// map returns a stream of objects (which will use primitive wrapper classes)
		
		// mapToDouble will unbox the wrapper class and return a stream of primitives
		
		// mapToInt -> IntStream
		// mapToDouble -> DoubleStream
		// mapToLong -> LongStream
		
		// we can also simplify the above code - we don't need to call map and then mapToPrimitive
		books.stream()
				.mapToDouble(book -> book.getRating())
				.average()
				.ifPresent(System.out::println); // remember it returns an Optional - so we need to act accordingly 
		
		IntStream intS = IntStream.of(1, 23, 3, 4, 5 ,7);
		DoubleStream doubleS = DoubleStream.of(1, 23, 3, 4, 5 ,7);
		LongStream longS = LongStream.of(1, 23, 3, 4, 5 ,7);
		
		Stream<Integer> boxedInts = intS.boxed(); // can use boxed() to get a Stream typed with the object wrapper class for the primitives
		
		Stream<Double> objectStream = doubleS.mapToObj(val -> val); // or use the mapToObj() method...
		
		
	}
	
	

}
