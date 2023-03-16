package com.revature.functional.designpatterns.fluent;

public class FluentShopping {

	public static void main(String[] args) {

		// This works but is clunky and not very functional.
		Order myOrder = new Order();

		myOrder.add("Monitor");
		myOrder.add("Instant Coffee");
		myOrder.add("Keyboard");

		myOrder.deliverAt("123 Main Street");

		myOrder.place();

		System.out.println("****************************************");

		// Let's try with some chaining (by editing instance order methods to return an
		// Order object - I made a new class)
		new OrderV2().add("Monitor").add("Instant Coffee").add("Keyboard").deliverAt("123 Main Street").place();

		System.out.println("****************************************");

		// let's see one more way
		// delegating the creation of the order in the place function
		FluentOrder.place(
				order -> order.add("Monitor").add("Instant Coffee").add("Keyboard").deliverAt("123 Main Street"));

	}

}
