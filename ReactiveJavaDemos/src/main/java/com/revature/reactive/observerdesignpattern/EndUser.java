package com.revature.reactive.observerdesignpattern;

public class EndUser implements Observer {
	
	String name;
	
	EndUser(String name, SubjectLibrary subject) {
		this.name = name;
		subject.subscribeObserver(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void update(String avail) {
		System.out.println("Hello " + name + "! We are happy to notify you that your book is now " + avail);
	}

}
