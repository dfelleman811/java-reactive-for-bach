package com.revature.reactive.rxjava.operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class Operators {

	public static void main(String[] args) {
		
		Observable.just(20, 80, 93, 53, 103, 54, 82, 90, 87) // Source Observable (upstream)
			.filter(e -> e > 75) // this is behaving as an observer of the source AND an observable for the subscribe() observer
			.sorted()
			.subscribe(e -> System.out.println("Grade above 75: " + e)); // terminal observer
		
		/*
		 * Suppressing Operators
		 */
		// filter we've seen
		// take and skip
		
		System.out.println("*********take(5)************");
		
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.take(5)
			.subscribe(System.out::println);

		System.out.println("*********skip(5)************");
		
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.skip(5)
			.subscribe(System.out::println);
		
		// distinct
		
		List<String> list = List.of("One", "two", "two", "three", "four", "four", "five", "six", "six", "two", "one", "seven");
		
		System.out.println("*********distinct()************");
		
		Observable.fromIterable(list)
			.distinct()
			.subscribe(System.out::println);
		
		// elementAt
		System.out.println("*********elementAt()************");
		Observable.fromIterable(list)
			.elementAt(5)
			.subscribe(System.out::println);
		
		
		/*
		 * Transforming Operators
		 * 
		 */
		
		// map we've seen
		// sorted we've seen
		
		// cast - to cast each element to another class .cast(SomeClass.class) <- we pass the class
		
		
		//scan - takes a function - performs the function on the first element and passes that result to be used as input for next element
		System.out.println("*********scan()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
			.scan((x, y) -> x + y)
			.subscribe(System.out::println);
		

		System.out.println("*********repeat()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.repeat(3)
		//.doOnComplete(() -> System.out.println("Iteration Complete")) // this is an Action Operator
		.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));
		
		 /*
		  * Reducing Operators
		  */
		
		// count - exactly like it sounds - returns a Single<Long>

		System.out.println("*********count()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.count()
		.subscribe(System.out::println);
		
		// reduce() - identical to scan, but only emits one (final) result
		System.out.println("*********reduce()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.reduce((a,b) -> a + b)
		.subscribe(System.out::println);
		
		// contains 
		
		System.out.println("*********contains()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.contains(5)
		.subscribe(System.out::println);
		
		// all
		System.out.println("*********all()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.all(e -> e > 0)
		.subscribe(System.out::println);
		
		// any
		System.out.println("*********any()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.any(e -> e == 2)
		.subscribe(System.out::println);
		
		/*
		 * Collecting Operators (part of Reducing)
		 * 
		 * toList, toSortedList, toMap, collect
		 */
		
		System.out.println("*********toList()************");
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.toList()
		.subscribe(System.out::println);
		
		System.out.println("*********toMap()************");
		Observable.just("Alpha", "Beta", "Delta", "Epsilon", "Gamma")
		.toMap(e  -> e.charAt(0))
		.subscribe(System.out::println);
		
		/*
		 * Error Recovery Operators
		 */
		
		/*
		 * Action Operators
		 */
		
		
	}
	
}
