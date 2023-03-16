package com.revature.functional.designpatterns.behavioral.command;

public class AC {
	
	// commands for the AC that can be invoked by the client through the Invoker
	// this is our Receiver (pre Java 8 and with Imperative Style - we would need to have created separate classes for all of these commands)
	// with lambdas - we don't need to have concrete implementations of the Command Interface for every action
	public void turnOn() {
		System.out.println("Turning on the AC");
	}
	
	public void turnOff() {
		System.out.println("Turning off the AC");
	}
	
	public void increaseTemp() {
		System.out.println("Increasing the temperature");
	}
	
	public void decreaseTemp() {
		System.out.println("Decreasing the temperature");
	}

}
