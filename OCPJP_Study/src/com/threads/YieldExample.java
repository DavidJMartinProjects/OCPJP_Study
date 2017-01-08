/*
 * The yield() method allows us to  pause the thread which is current executing and allow it to give way to other threads of the same priority to the Scheduler
 * 	 - If all waiting Threads have a lower priority or if there is no waiting Threads then the same Thread will continue its execution.
 *   - If there are several Threads available & waiting with same priority then we can't predict exactly which Thread will get chance for execution.
 *   - The Thread which is yielded relies on the mercy of the Thread scheduler with regards to when it get a chance once again for execution.
 */

package com.threads;

class MyRunnable implements Runnable { //implement the Runnable interface
	public void run() { // override the run() method
		Thread.yield(); // pause the thread which is current executing and allow it to give way to other threads, of the same priority to the Scheduler
		System.out.println(Thread.currentThread().getName() + " Thread Task"); // print the name of the current thread to the console
	}
}

public class YieldExample {
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable(); // create a new MyRunnable object
		Thread t1 = new Thread(r1, "MyRunnable"); // create a new Thread object 
		t1.start(); // call the start() method on the t1 thread
		
		for(int i=0; i<5; i++) { // loop 5 times
			System.out.println("Main Thread Task"); // print message to console
		}		
	}
}

