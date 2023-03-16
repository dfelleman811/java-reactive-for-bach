package com.revature.operations;

import com.revature.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOperation {
	
	//map() takes a Function<T, R> - takes some input and returns an output 
	// each element in the stream will be input and returned after some operation is done on it
	
	public static void main(String[] args) {
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.map(e -> e * 5)
			.forEach(System.out::println);
		
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("The Sword of Shannara", "Terry Brooks", "Fantasy", 3.76));
		books.add(new Book("Neverwhere", "Neil Gaiman", "Fantasy", 4.17));
		books.add(new Book("The Shining", "Stephen King", "Horror", 4.25));
		books.add(new Book("Reprieve", "James Han Mattson", "Horror", 3.45));
		books.add(new Book("Mexican Gothic", "Silvia Moreno-Garcia", "Horror", 3.69));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.27));
		
		// before we filtered the list
		List<Book> filteredBooks = books.stream()
										.filter(b -> b.getGenre().equalsIgnoreCase("Horror"))
										.filter(b -> b.getRating() > 3.5)
										.collect(Collectors.toList());
		filteredBooks.forEach(System.out::println);
		
		// maybe we are only interested in the names .. instead of returning the complete objects, we can have only the names
		books.stream()
			.filter(b -> b.getGenre().equalsIgnoreCase("Horror"))
			.filter(b -> b.getRating() > 3.5)
			.map(b -> b.getName())
			.forEach(System.out::println);
		
		// because map() takes a Function<T, R> - we can take a stream of one type of elements and return a stream of another type of elements
		// NB - do not try to change the state of an object using map (or at all really in functional programming) - may result in ConcurrentModificationException at Runtime
		
	}

}
