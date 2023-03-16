package com.revature.functional.designpatterns.behavioral.command;

public class CommandDesignPattern {
	
	// Scenario -> Air conditioner remote (invoker) that controls the commands for the AC
	
	public static void main(String[] args) {
		
		// Create two ac instance
		AC ac1 = new AC();
		AC ac2 = new AC();
		
		// Instantiate AC Remote and pass the command implementation as a lambda to the remote
		ACAutomationRemote remote = new ACAutomationRemote();
		remote.setCommand(() -> ac2.turnOn());
		
		// execute the command
		remote.buttonPressed();
		
		// we can pass any number of commands to the receiver without changing our AC client code.
		
	}

}
