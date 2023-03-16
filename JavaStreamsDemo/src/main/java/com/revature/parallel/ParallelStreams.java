package com.revature.parallel;

import com.revature.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < 100; i ++) {
			employees.add(new Employee("John", 50000));
			employees.add(new Employee("Geraldine", 75000));
			employees.add(new Employee("Peter", 65000));
			employees.add(new Employee("Hannah", 155000));
			employees.add(new Employee("Oscar", 95000));
			employees.add(new Employee("Betty", 45000));
		}
		
		
		long start;
		long end;
		
		// count employees with salaries greater than $50,000 -> with sequential streams
		
		
		start = System.currentTimeMillis();
		
		System.out.println("Performing Sequentially: " + employees.stream()
			.filter(e -> e.getSalary() > 50000)
			.count());
		end = System.currentTimeMillis();
		
		System.out.println("Total time taken: " + (end-start) + "ms");
		
		
		
		// and the same with parallel
		start = System.currentTimeMillis();
		
		System.out.println("Performing Parallelly: " + employees.parallelStream()
			.filter(e -> e.getSalary() > 50000)
			.count());
		
		end = System.currentTimeMillis();
		
		System.out.println("Total time taken: " + (end-start) + "ms");
		
		/*
		 * WHen using parallel....
		 * 
		 * The Stream should be: 
		 * 		Stateless - 
		 * 		
		 * 		Non-interfering - data source is not affected during operation
		 * 
		 * 		Associative - one operation result should not be affected by the order of the data is processing
		 * 
		 * 		no synchronization issues or visibility issues (should bee easy enough if you're sticking to the characteristics of functional programming and not having any side eggects
		 * 
		 * 
		 * really only need to use if sequential processing is costing you something - and make sure to measure to see that parallel would be faster
		 */
		
	}
	
}
