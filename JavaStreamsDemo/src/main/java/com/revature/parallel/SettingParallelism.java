package com.revature.parallel;

import com.revature.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		
		System.out.println(ForkJoinPool.getCommonPoolParallelism()); 
		
		ForkJoinPool pool = new ForkJoinPool(2);
		
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < 100; i ++) {
			employees.add(new Employee("John", 50000));
			employees.add(new Employee("Geraldine", 75000));
			employees.add(new Employee("Peter", 65000));
			employees.add(new Employee("Hannah", 155000));
			employees.add(new Employee("Oscar", 95000));
			employees.add(new Employee("Betty", 45000));
		}
		
		
		long count = pool.submit(() -> 
			employees.parallelStream()
						.filter(e -> e.getSalary() > 50000)
						.count()).get();
		System.out.println(count);
		
		
		/*
		 * 
		 * If the process is computationally intensive... then the number of threads should be <= the number of cores
		 * 
		 * if the process is IO intensive... then the number of threads can be greater than the number of cores
		 * 
		 */
	}
	
}
