package com.revature.reactive.rxjava.observable;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class ConnectableObservables {

	public static void main(String[] args) throws InterruptedException {
		
		//Observable.interval(1, TimeUnit.SECONDS); // this is a cold observable - any new subscirtion will get all elements from scratch
		
		
		// to make it hot - call the .publish() method - this will return a ConnectableObservable
		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
		
		// to start it - we need to invoke the connect method to fire the emissions
		source.connect();
		
		// so noow one observer comes and subscribes
		source.subscribe(e->System.out.println("Observer 1: " + e));
		
		// ten seconds later another observer subscribes
		Thread.sleep(10000);

		source.subscribe(e->System.out.println("Observer 2: " + e));
		
		Thread.sleep(10000);
		
		// analogy -> think of hot observables like a radio station. When you tune to the station - you start hearing what is currently being broadcasted - not anything that comes before
	}

}
