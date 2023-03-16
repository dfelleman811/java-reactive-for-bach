package com.revature.reactive.rxjava.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {
	
	public static void main(String[] args) {
		
		// 1. Create an Observable to emit data - using the anonymous class method here so we can see what's happening - but lambdas can and likely should be used.
		// 1a. We need to implement the Observables onSubscribe() method (to tell the Observable what to do when an Observer Subscribes to it.
		
		Observable<Integer> source = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() { // this is only one way to create an Observable

			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
				try {
				emitter.onNext(10);
				emitter.onNext(11);
				emitter.onNext(12);
				emitter.onNext(13);
				emitter.onComplete();
				} catch (Throwable t) {
					emitter.onError(t);
				}
			}});
		
		// 2. Create an Observer - where we need to implement onSubcscribe(Disposable d), onNext(T value), onError(Throwable e), and  onComplete()
		
		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("Subscribed");
				
			}

			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println("On Next: " + t);
			}

			@Override
			public void onError(@NonNull Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed!");
			}};
		
			
			// 3. Subscribe to the Observable - we pass the Observer which has all the implementations needed
			source.subscribe(observer);
			
			// When subscribe is called - the Observable will start emitting data (what we implemented when creating the Observable)
			// Add break points to see it step by step
			
			// 1. subscribe is invoked (the observable is subscribing to the observable
			// 2 . onSubcribe is called by the Observable when it subscribes and Subscribed is printed to console
			// 3. and then the Observable onNext(10) is invoked
			// 4. and then the Observer onNext() for each piece/element of data
			// Once done - it invokes onComplete() and prints Completed
		
	}

}
