package com.revature.reactive.rxjava.observable;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Disposing {
	
	private static final CompositeDisposable cDisp = new CompositeDisposable();
	
	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		
		Disposable d1 = source.subscribe(e -> System.out.println("Observer 1: " + e));
	
		Disposable d2 = source.subscribe(e -> System.out.println("Observer 2: " + e));
	
		Thread.sleep(5000);
		
		d1.dispose();
		
//		// Composite Disposable allows us to unsubscribe multiple Observers at once
//		
//		cDisp.addAll(d1, d2);
//		cDisp.dispose();
//		
		Thread.sleep(5000);
		
		
		
		
	}

}
