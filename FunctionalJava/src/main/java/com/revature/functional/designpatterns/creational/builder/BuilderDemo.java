package com.revature.functional.designpatterns.creational.builder;

public class BuilderDemo {

	public static void main(String[] args) {

		MobilePhoneBuilder builder = new MobilePhoneBuilder();
		
		
		// by setting up and creating objects with our builder - we don't need to send values for every field
		// especially important to note that we haven't needed to create a constructor for each way that we can instantiate a phone
		// our builder is taking care of this for us
		MobilePhone mobile = builder.with(myBuilder -> {
			
									myBuilder.ram = 4;
									myBuilder.battery = 4000;
									myBuilder.processor = "A13";
									
								}).createMobilePhone();
		
		System.out.println(mobile);
		
		
	}
	
}
