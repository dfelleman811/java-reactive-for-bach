package com.revature.functional.designpatterns.creational.builder;

import java.util.function.Consumer;

public class MobilePhoneBuilder {
	
	int ram, storage;
	int battery;
	int camera;
	String processor;
	double screenSize;

	
	// Imperative Style would be to create setters for each attribute and then create the object
	// Functional way - we will create a method that will take a Consumer<MobilePhoenBuilder>
	// a Higher Order Function!
	public MobilePhoneBuilder with(Consumer<MobilePhoneBuilder> buildFields) {
		
		buildFields.accept(this);
		return this;
	}
	
	public MobilePhone createMobilePhone() {
		return new MobilePhone(this);
	}
	
}
