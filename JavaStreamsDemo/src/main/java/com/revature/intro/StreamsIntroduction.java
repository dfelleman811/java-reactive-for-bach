package com.revature.intro;

import com.revature.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIntroduction {

	public static void main(String[] args) {
		
		
		List<Book> books = new ArrayList<>();
		
		// Imperative Style
		// filter out books with horror genre adn rating greater than 3
//		List<Book> popularHorrorBooks = new ArrayList<>();
//		for (Book b : books) {
//			if (b.getGenre().equalsIgnoreCase("horror") && b.getRating() > 3) {
//				popularHorrorBooks.add(b);
//			}
//		}
		
		// With SQL => select * from books where genre = 'horror' and rating > 3;
		// Declarative Programming with Streams allow us to simplify the above code
		
		// Stream takes data from a source
		// does all the processing
		// returns (or consumes) the data
		// This is called a Stream Pipeline - consists of a Source (collection, array generator function, io channel, 0 or more Intermediate Operations that return a new stream, followed by a Terminal Operation to end the pipeline (they return a non streaming result)
//		List<Book> filteredBooks = books.stream() // Source
//				.filter(b -> b.getGenre().equalsIgnoreCase("horror")) // Intermediate Operation
//				.filter(b -> b.getRating() > 3.5) // Intermediate Operation
//				.collect(Collectors.toList()); // Terminal Operation
//		
//		// not only collects are sources - can be String, IO resources, files, arrays, etc
//		// can also do parallel processing (for large collections of data)
//		// parallel code is normally complicated - with streams you only add .parallel()
//		
//		List<Book> parallelFilteredBooks = books.parallelStream() // or books.stream().parallel()
//				.filter(b -> b.getGenre().equalsIgnoreCase("horror"))
//				.filter(b -> b.getRating() > 3.5)
//				.collect(Collectors.toList());
//		
//		// Observing the stream
//		// the code looks like a pipeline - let's break it up
//		
//		// 1. Source stream
//		Stream<Book> bookStream = books.stream(); // this returns a stream of all of the elements present in that collection
//		
//		// 2. Intermediate Op
//		Stream<Book> horrorBooks = bookStream.filter(b -> b.getGenre().equalsIgnoreCase("horror")); // returns a NEW stream with only the filtered elements
//		
//		// 3. Another Intermediate Op
//		Stream<Book> popHorrorBooks = horrorBooks.filter(b -> b.getRating() > 3.5);
//		
//		// 4. Terminal Op
//		List<Book> finalList = popHorrorBooks.collect(Collectors.toList());
		
		
		// let's see it in action
		books.add(new Book("The Sword of Shannara", "Terry Brooks", "Fantasy", 3.76));
		books.add(new Book("Neverwhere", "Neil Gaiman", "Fantasy", 4.17));
		books.add(new Book("The Shining", "Stephen King", "Horror", 4.25));
		books.add(new Book("Reprieve", "James Han Mattson", "Horror", 3.45));
		books.add(new Book("Mexican Gothic", "Silvia Moreno-Garcia", "Horror", 3.69));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.27));
		
		List<Book> popularHorrorBooks = books.stream() // Source
				.filter(b -> b.getGenre().equalsIgnoreCase("horror")) // Intermediate Operation
				.filter(b -> b.getRating() > 3.5) // Intermediate Operation
				.collect(Collectors.toList()); // Terminal Operation
		
		popularHorrorBooks.forEach(System.out::println);
		
		System.out.println("************************************");
		
		books.stream()
			.filter(b -> b.getGenre().equalsIgnoreCase("fantasy"))
			.filter(b -> b.getRating() > 3)
			.forEach(System.out::println);
		
		// can we generate the stream and use the same stream? 
		
		System.out.println("Can we use the same stream more than once?");
		Stream<Book> bookStream = books.stream();
		
		bookStream
			.filter(b -> b.getGenre().equalsIgnoreCase("fantasy"))
			.filter(b -> b.getRating() > 3)
			.forEach(System.out::println);
		
		// unfortunately - No. it will result in java.lang.IllegalStateException: stream has already been operated upon or closed
		// Stream are immutable - we cannot add or remove anything to an existing stream once created and cannot operate on it once the stream has been terminated.
		// it's just a fancy iterator - it doesn't store any data like a collection does
//		bookStream
//			.filter(b -> b.getGenre().equalsIgnoreCase("horror"))
//			.filter(b -> b.getRating() > 3)
//			.forEach(System.out::println);
	}
	
}


















