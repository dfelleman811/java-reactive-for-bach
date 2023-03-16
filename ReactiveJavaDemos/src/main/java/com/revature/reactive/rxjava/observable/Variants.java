package com.revature.reactive.rxjava.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
	
	public static void main(String[] args) {
		
		Observable<String> source = Observable.just("dan", "jess", "matt");
		Observable<String> emptySource = Observable.empty();
		
		// first() - takes a default and returns a Single - default is for if there's an empty observable
		source.first("name")
				.subscribe(System.out::println);
		
		emptySource.first("name").subscribe(System.out::println);
		
		System.out.println();

//		Single<String> singleSource = Single.just("one item");
//		
//		singleSource.subscribe(System.out::println);
		
		// firstElement() - returns a Maybe (0 or 1 emissions).
		source.firstElement().subscribe(System.out::println); // if value (1 emission) onSuccess() will be called which in MaybeObservable will call onNext();
		emptySource.firstElement().subscribe(System.out::println); // if empty (0 emissions) onComplete will be called and no output
		
		System.out.println();
		// you can still provide those methods (i.e. if you want to know that it was completed...if 0 elements it will call onComplete
		emptySource.firstElement().subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("Completed"));
		
		System.out.println();

		// Completable - does not emit any data - only concerned with the action being completed (success or fail)
		Completable completable = Completable.complete();
		
		completable.subscribe(() -> System.out.println("Completed...")); // takes nothing or ActionOnComplete
		
		System.out.println();
		// completable has methods like .fromRunnable() - which is nice so we can get a completed message once the task is done
		
		Completable.fromRunnable(()->System.out.println("Some process executing..."))
			.subscribe(()->System.out.println("The process executed successfully"));
		
	}

}
