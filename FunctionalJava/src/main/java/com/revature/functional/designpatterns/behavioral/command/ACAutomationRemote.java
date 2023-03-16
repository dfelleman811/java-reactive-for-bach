package com.revature.functional.designpatterns.behavioral.command;

/**
 * the Invoker
 * @author DanielFelleman
 *
 */
public class ACAutomationRemote {

	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void buttonPressed() {
		command.execute();
	}
 	
}
