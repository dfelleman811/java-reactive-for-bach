package com.revature.functional.techniques.closures;

public class JavaClosure {

	public static void main(String[] args) {
		
		int val = 111;
		
		//val =112;
		
		// an implementation of Task that takes nothing but prints out a variable defined in the main method
		// this is a closure - it's using the free variable val defined in its lexical scope
		Task lambda = () -> {
		
			// only possible if the value is final or effectively final
			//val = 12;
			
			System.out.println(val);
			System.out.println("Task completed");
			
		};
		
		// a method that calls the lambda - silly but for demonstration purposes
		printValue(lambda);
		
	}

	private static void printValue(Task lambda) {
		// important to note that we are not calling the lambda in its own scope (which is inside of the main method)
		// and the val variable is not present in this scope!!
		lambda.doTask();
		
	}
	
	
	// the JRE is keeping track of val - when we pass the lambda to the printvalue method the value of the variable val (111) is also passed
	// the value is coming from the closure
	// whenever a lambda expression uses a free variable in the same scope the value of that variable is saved
	// and whenever we call the lambda it goes along with that
	// closures control what is and what isn't in the scope of a particular function
	// along with which variables are shared between sibling functions in the same, contained scope
	 
	
}
