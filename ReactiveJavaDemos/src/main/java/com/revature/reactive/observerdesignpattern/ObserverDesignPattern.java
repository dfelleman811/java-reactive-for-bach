package com.revature.reactive.observerdesignpattern;

public class ObserverDesignPattern {
	
	public static void main(String[] args) {
		// creating the subject (or observable)
		Book book = new Book("Goosebumps", "Horror", "RL Stein", 200, "SoldOut");
		
		// create observers to subscribe to the book
		EndUser user1 = new EndUser("dan", book);
		EndUser user2 = new EndUser("jan", book);
		EndUser user3 = new EndUser("van", book);
		
		System.out.println(book.getInStock());
		
		book.setInStock("In Stock");
		
		
	}

}
