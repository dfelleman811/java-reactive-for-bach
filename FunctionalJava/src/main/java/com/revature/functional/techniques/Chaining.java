package com.revature.functional.techniques;

import java.util.function.Function;

public class Chaining {
	
	public static void main(String[] args) {
		
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = s -> System.out.println(s);
		
//		c1.accept("Hello");
//		c2.accept("Hello");
		
		Consumer<String> c3 = s -> {
			
			c1.accept(s);
			c2.accept(s);
		};
		
		c3.accept("Hello");
		
		
		// Above isn't really chaining - we would want something like the below
		Consumer<String> c4 = c1.thenAccept(c2);
		
		// this call is now executing the complete chain we created 
		c4.accept("DanFelleman");
		
		Function<Integer, Integer> f1 = s -> s+2;
		Function<Integer, Integer> f2 = s -> s*2;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		
		int result = f3.apply(10);
		System.out.println(result);
	}

}
