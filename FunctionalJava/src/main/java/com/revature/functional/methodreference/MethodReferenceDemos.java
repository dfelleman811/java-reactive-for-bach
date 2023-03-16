package com.revature.functional.methodreference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemos {
	
	public static void main(String[] args) {
		
		// Method Reference of an Object's Instance Method
		// Consumer for example
		Consumer<String> supplier = s -> System.out.println(s);
		
		// instead we can write it like this
		Consumer<String> supplierRef = System.out::println; // System.out returns a PrintStream Object
		
		
		// Method REference of a Class' static method
		Supplier<Double> randInt = () -> Math.random();
		//can be rewritten as
		Supplier<Double> randIntRef = Math::random;
		
		// If the static method has parameters, it (wha'ts it?) will interpret the arguments for us
		BiFunction<String, String, String> biFun = (a, b) -> a+b;
		BiFunction<String, String, String> biFunRef = ExClass::joinTwo;
		
		
		// MethodReference of an instance method from a class
		Function<String, Integer> lenFun = s -> s.length();
		// can be written as
		Function<String, Integer> lenFunRef = String::length;
		
		// can also be used for Constructors! Sometimes called Constructor Reference
		
		
		
		
	}

}
class ExClass {
	static String joinTwo(String a, String b) {
		return a + b;
	}
	
}
