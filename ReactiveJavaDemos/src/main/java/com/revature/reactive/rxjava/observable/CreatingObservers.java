package com.revature.reactive.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObservers {
	
	public static void main(String[] args) {
		
		
		// we saw in Observable and Observer how to create an observer using an anonymous class and implementing all of the observer's methods...a bit long and messy
		// different signatures of the subscribe method to create an observer
		
		Observable<String> source = Observable.just("red", "orange",  "yellow",  "green",  "blue",  "indigo", "violet");
		
		
		// subscribe(onNext, onError, onComplete); 
		source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!")); 
		
		System.out.println("*********************************");
		
		// subscribe(onNext, onError) - useful if there are infinite numbers of emissions -since no onComplete is implemented
		source.subscribe(System.out::println, Throwable::printStackTrace);
		
		System.out.println("*********************************");
		
		
		// subscribe(onNext)
		source.subscribe(System.out::println);
		
	}

}
