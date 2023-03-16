package com.revature.functional.optionals;

import java.util.Optional;

public class UnwrappingOptionals {
	
	public static void main(String[] args) {
		
		// Getting the values back from the Optional wrapper
		
		Integer a = 10;
		
		Optional<Integer> optional = Optional.of(a);
		
		// get - DONT USE THIS - it's risky - it can throw a NoSuchElementException - totally defeats the purpose!!
		Integer intVal = optional.get();
		System.out.println(intVal);
		
		Optional<Integer> empty = Optional.empty();
		//empty.get();
		
		// only use get() with isPresent()
		Integer val = empty.isPresent() ? optional.get() : 0;
		System.out.println(val);
		
		
		// but there are much better options
		// orElse sets default if value is absent
		// N.B. orElse always generates the default object - even if Optional is present (orElseGet only executes the supplier function if value is absent)
		Integer orElse = optional.orElse(0);
		System.out.println(orElse);
		
		Integer orElser = empty.orElse(0);
		System.out.println(orElser);
		
		
		// orElseGet can also set the default value, but uses a Supplier
		Integer orElseGet = empty.orElseGet(()->0);
		System.out.println(orElseGet);
		
		
		// if you still want the space for an absent value and want an exception to be thrown....orElseThrow
		
		Integer orElseThrow = empty.orElseThrow(IllegalArgumentException::new);
		
		// new since Java 10 - orElseThrow() with no args -> will throw NoSuchElementException (like the get() method). 
		
		
	}

}
