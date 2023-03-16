package com.revature.functional.designpatterns.behavioral.iterator;

import java.util.function.Consumer;
import java.util.function.Function;

public class MyArrayList {
	
	Object[] elements = new Object[5];
	
	public MyArrayList(Object[] elements) {
		this.elements = elements;
	}
	
	// create an internal iterator so the outside world doesn't need to know the internal implementations
	
	// create our own forEach that accepts a consumer and iterate through the container
	public void myForEach(Consumer<Object> action) {
		
		for (int i = 0; i < elements.length; i++) {
			action.accept(elements[i]);
		}
	}
	
	public Object[] add(Function<Object, Object> function) {
		
		for (int i = 0; i < elements.length; i++) {
			elements[i] = function.apply(elements[i]);
		}
		return elements;
	}

}
