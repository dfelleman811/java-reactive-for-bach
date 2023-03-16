package com.revature.functional.methodreference;

import java.util.function.Function;

public class ConstructorReference {

	public static void main(String[] args) {

		Function<Runnable, Thread> threadGenerator = r -> new Thread(r);
		// can also be written like
		Function<Runnable, Thread> threadGenRef = Thread::new;
		
		Runnable task1 = () -> System.out.println("Task 1 executed by: " + Thread.currentThread().getName()); // this lambda cannot be written as a method reference
		
		Runnable task2 = () -> System.out.println("Task 2 executed by: " + Thread.currentThread().getName());
		
		
		Thread t1 = threadGenRef.apply(task1);
		Thread t2 = threadGenRef.apply(task2);
		
		t1.start();
		t2.start();
		
		// lambda works still of course
		threadGenerator.apply(task2).start();
		
		// more compact
		threadGenRef
			.apply(()->System.out.println("Task 3 executed by: " + Thread.currentThread().getName()))
			.start();
		

	}

}
