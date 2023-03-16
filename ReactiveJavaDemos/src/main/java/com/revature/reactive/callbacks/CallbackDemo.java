package com.revature.reactive.callbacks;

// Demo for using callbacks - can get very completed. 
// RxJava has a solution to this using the Observer Pattern 
public class CallbackDemo {

	public static void main(String[] args) {
		
		
		System.out.println("Main Thread is running");
		
		// create a thread that will run the implementation inside async
		
		Runnable r = new Runnable() {
			
			public void run() {
				new CallbackDemo().runningAsync(new Callback() {

					public void pushData(String data) {
						System.out.println("Callback data: " + data);
					}

					public void pushComplete() {
						System.out.println("Callback done!");
					}

					public void pushError(Exception e) {
						System.out.println("Callback error, got an exception: " + e);
					}

					
				});
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		// put main thread to sleep so it doesn't terminate until the async thread completes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main thread completed");
	}
	
	// method to mimic async
	public void runningAsync(Callback callback) {
		System.out.println("I am running in a separate thread.");
		sleep(1000);
		// call once the task is completed
		callback.pushData("Data1");
		callback.pushData("Data2");
		callback.pushData("Data3");
		
		callback.pushError(new RuntimeException("Oopsies!"));
		callback.pushComplete(); 
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
