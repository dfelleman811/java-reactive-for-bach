package com.revature.reactive.observerdesignpattern;
// this is the Subject (or Observable in RxJava)
public interface SubjectLibrary {
	
	void subscribeObserver(Observer observer);
	
	void unsubscribeObserver(Observer observer);
	
	void notifyObserver();

}
