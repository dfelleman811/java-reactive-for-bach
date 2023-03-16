package com.revature.functional.optionals;

import java.util.Optional;

public class WorkingWithOptionals {
	
	public static void main(String[] args) {
		
		Optional<String> optional = Optional.of("Value");
		Optional<String> empty = Optional.empty();
		
//		// map() - if value is present it transforms or maps the value into another optional
//		
//		Optional<String> mappedVal = optional.map(val -> "Replace"); // will wrap the return in an optional
//		System.out.println(mappedVal);
//		System.out.println(mappedVal.orElseGet(() -> "I was empty!"));
//		
//		// if the Optional is empty - it will return an empty optional
//		Optional<String> mappedEmpty = empty.map(val -> "Replace");
//		System.out.println(mappedEmpty);
//		System.out.println(mappedEmpty.orElseGet(() -> "I was empty!"));
//		
//		// shorter-ish
//		String orElseGet = optional.map(val -> "Replaced").orElseGet(() -> "I was empty...");
//		System.out.println(orElseGet);
//		String orElseGetEmpty = empty.map(val -> "Replaced").orElseGet(() -> "I was empty...");
//		System.out.println(orElseGetEmpty);
//		
//		
//		
//		// filter() - whereas map modifies the value, filter checks a condition on the optional (using a Predicate)
//		// if condition is satisfied it returns the same optional again
//		Optional<String> filtered = optional.filter(val -> val.equalsIgnoreCase("Value"));
//		System.out.println(filtered.orElse("Empty"));
//		
//		
//		// flatMap() - similar to map, but the mapping function's result is already an optional. does not wrap the val returned in an optional, because it requires the mapping function to return one already Function<T, Optional<? extends R>>
//		
//		Optional<String> flatMapped = optional.flatMap(val -> Optional.of("Replaced"));
//		System.out.println(flatMapped);
//		
		
		
		// ifPresent - if value is present then this method executes a Consumer on that value otherwise does nothing
		optional.ifPresent(System.out::println);
		optional.ifPresent(val -> System.out.println("This is a " + val));
		
		// if it's empty - it doesn't do anything - not even throw an exception
		empty.ifPresent(System.out::println);
		
		// but what if we want it to?
		
		// ifPresentOrElse - takes a consumer and a runnable ... ifPresentOrElse(Consumer action, Runnable emptyAction) ... one for if value is present and the other if the optional is empty  
		optional.ifPresentOrElse(val -> System.out.println(val), () -> System.out.println("The optional was empty")); // N.B. added in Java 9
		Optional.empty().ifPresentOrElse(val -> System.out.println(val), () -> System.out.println("The optional was empty")); // N.B. added in Java 9
		
		
		// stream - if value is present it returns a sequential stream containing only that value otherwise returns an empty string
		optional.stream().forEach(System.out::println);
		Optional.empty().stream().forEach(System.out::println); // just uses an empty stream and so has no output
		
		// or - takes a supplier and returns same optional if it has a value. if optional is empty - it returns the new optional supplied by the supplier
		optional
			.or(() -> Optional.of("New Value"))
			.ifPresent(System.out::println);
		Optional.empty()
			.or(() -> Optional.of("New Value"))
			.ifPresent(System.out::println);
		// important that the supplying function is not null - this will result in a NullPointerException
		//Optional.empty().or(() -> null).ifPresent(System.out::println);
		
		// equals - for checking if another object is equal to the object or not (if it's also an optional AND if both are empty OR both contain equal values - via the .equals() method
		System.out.println(optional.equals(Optional.of("Value")));
		System.out.println(optional.equals(Optional.of("value")));
		System.out.println(Optional.empty().equals(Optional.empty()));
		
		
		// hashcode - returns the hashcode of the value - returns 0 if empty
		System.out.println(optional.hashCode());
		System.out.println(Optional.empty().hashCode());
		
	}

}
