package com.revature.reactive.rxjava.observable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ColdObservable {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Observable<Integer> source = Observable.fromIterable(list);
		
		source.subscribe(System.out::println);
		
		list = getData(list);
		
		source.subscribe(System.out::println); 
		
	}
	
	public static List<Integer> getData(List<Integer> list) {
		list.add(10);
		return list;
	}
	
	
}
