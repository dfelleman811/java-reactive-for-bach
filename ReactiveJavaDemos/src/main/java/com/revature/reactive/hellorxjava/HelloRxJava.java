package com.revature.reactive.hellorxjava;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String[] args) {

		// Create a publisher (or an observable) who's sole purpose is to generate or
		// emit events/data one after the other
		// basically a stream of events of data

		Observable<String> source = Observable.create(
				// e is an emitter
				e -> {
					e.onNext("Hello");
					e.onNext("RxJava");
				});
		
		// Observer to subscribe to the Observable source ot have access to the events generated
		source.subscribe(e -> System.out.println("Observer 1: " + e));
		
		// there can be many Observers
		source.subscribe(e -> System.out.println("Observer 2: " + e));
		
		// we can create as many observers as we need that can perform operations on the same data that is emitted from the Observable source
	}

}
