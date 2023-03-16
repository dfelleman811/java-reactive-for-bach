package com.revature.functional.optionals;

import java.util.Optional;

public class OptionalCreation {

	public static void main(String[] args) {
		
		String val = "A string";
		
		Optional<String> optional = Optional.of(val);
		
		// empty optional
		Optional<Integer> emptyOpt = Optional.empty();
		
		// not sure if value is present or is null?
		//use nullable
		
		Optional<String> nullable = Optional.ofNullable(val);
		Optional<String> emptyOptional = Optional.ofNullable(null); // this will create an empty optional
	}
	
}
