package com.revature.functional.designpatterns.behavioral.iterator;

public class IteratorPattern {
	
	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList(new Object[] {"Dan", "Jess","Chris", "Allary", "Minogue"});
		MyArrayList numList = new MyArrayList(new Object[] {1, 2, 3, 4, 5,6 ,7 ,8, 9});
		
		list.myForEach(System.out::println);
		
		numList.add(n -> (int) n + 10);
		
		numList.myForEach(System.out::println);
		
	}

}
