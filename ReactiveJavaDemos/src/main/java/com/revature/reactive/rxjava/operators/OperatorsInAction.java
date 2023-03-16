package com.revature.reactive.rxjava.operators;

import com.revature.reactive.rxjava.models.Employee;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {

	public static void main(String[] args) {

		Observable<Employee> obs = Observable.just(
				new Employee(101, "john", 50000, 4.0),
				new Employee(121, "greg", 150000, 4.4),
				new Employee(131, "minnie", 55000, 4.5),
				new Employee(141, "petra", 85000, 3.3),
				new Employee(151, "hermione", 75000, 3.8),
				new Employee(161, "ron", 250000, 3.7),
				new Employee(171, "george", 53000, 4.1),
				new Employee(181, "bunny", 60000, 4.4),
				new Employee(191, "peter", 70000, 2.9)
				);

		// need a list of 4 top employees
		obs
			.filter(e -> e.getRating() > 4)
			.sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating())) // pass a comparator to sort in descending order
			.map(e -> e.getName())
			.take(4)
			.subscribe(System.out::println);
		
		
		
		// another scenario - a list of expenses by person per month
		
		List<Integer> list = List.of(200, 500, 300, 350, 129, 234, 999, 1040, 4300, 987, 398, 789);
		// say we need to know a certain expense by a certain month
		
		Observable.fromIterable(list)
			.scan((a, b) -> a + b)
			.subscribe(System.out::println);
		
	}

}
