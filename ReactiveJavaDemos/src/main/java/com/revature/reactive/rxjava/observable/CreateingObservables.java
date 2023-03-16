package com.revature.reactive.rxjava.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class CreateingObservables {

	public static void main(String[] args) {

		// create - rarely used
		Observable<Integer> source = Observable.create(e -> {
			e.onNext(10);
			e.onNext(11);
			e.onNext(12);
			e.onComplete();
		}
		// to include onError() - enclose the onNext()s in a try and use onError in the
		// catch block
		);
		
		source.subscribe(System.out::println);
		
		
		// just() - pass the values in this just and onNext, onComplete, and onError are all implicity implemented - can pass 1 -10 elements
		
		Observable<String> justObservable = Observable.just("One", "Two", "Three");
		
		justObservable.subscribe(System.out::println);
		
		
		// fromIterable() - to Create an Observable from an Iterable
		
		List<String> strList = List.of("Rocks", "Paper", "Scissors");
		
		Observable<String> fromIterable = Observable.fromIterable(strList);
		fromIterable.subscribe(System.out::println);
		
		
		// range() - takes start value and the total count also have rangeLong
		
		Observable.range(5, 5).subscribe(System.out::println);
		
		
		// interval() takes the time period and the unit
		Observable.interval(1,  TimeUnit.SECONDS).subscribe(System.out::println); // runs on a separate thread and will run on the Computation Scheduler by default. main method will not wait for this to finish unless we invoke Sleep
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// fromFuture() - pass a future to create an observable from that future
		// empty(). will emit nothing, but simply call the onComplete Implementation
		// never(). also emits nothing, and never calls onComplete() - used for testing to prove that no emissions are coming from it
		// error() - takes an ExceptionSUpplier to supply an exception intentionally (like throw new...)
		//defer() - creates a separate state for each observer - takes a Supplier that also returns an observable - subscribe to the source...afterwards we can add more elements (modifying the state) and again we can subscribe -but will print all elements - accounts for state changes
		// fromCallable() - takes a Callable to create an Observable from that Callable
		
		
		List<String> names = new ArrayList<>();
		names.add("dan");
		names.add("grace");
		names.add("june");
		names.add("peter");
		
		Observable<String> obs = Observable.defer(() -> Observable.fromIterable(names));
		
		
		names.add("petunia");
		obs.subscribe(System.out::println);
		
		
		names.add("harvey");
		
		obs.subscribe(System.out::println);
		

	}

}
