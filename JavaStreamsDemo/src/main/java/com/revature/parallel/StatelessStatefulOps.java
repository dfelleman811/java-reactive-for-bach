package com.revature.parallel;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOps {
	
	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		
		List<Integer> nextList = list.parallelStream()
									.skip(2)
									.limit(5)
									.collect(Collectors.toList());
		
		System.out.println(nextList);
										
		
	}

}
