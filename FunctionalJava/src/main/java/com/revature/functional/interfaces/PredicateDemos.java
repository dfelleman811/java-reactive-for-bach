package com.revature.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemos {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		
		names.add("Peter");
		names.add("James");
		names.add("Larry");
		names.add("Miguel");
		names.add("Dan");
		names.add("Oscar");
		names.add("Justin");
		names.add("Melissa");
		
		Predicate<String> predicate = s -> s.contains("a");
		
		//names.stream().filter(predicate).forEach(System.out::println);
		
		List<String> filteredNames = filterList(names, predicate);
		
		System.out.println(filteredNames);
		
		System.out.println(filterList(names, s -> s.contains("e")));
		
		
	}
	
	public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
		List<T> newList = new ArrayList<>();
		
		for (T t : list) {
			if (predicate.test(t))
				newList.add(t);
		}
		return newList;
	}

}
