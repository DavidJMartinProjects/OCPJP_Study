/* this program demonstrates how we can't rely on the order in which multiple concurrent threads will be executed
 * the synchronized access modifier applied to the run() method ensures that this method can only be accessed by one thread at a time
 * the static Thread.sleep() method throws a checked exception and must be declared or handled, a try-catch block is recommended to be used in these situations where we call sleep()
 * the Thread.sleep() method throws an InteruptedException 
 
 * A thread can be in each of following states :
 * 	1. New/Alive - When the Thread Object has been instantiated (but the start() method has not yet been called)
 * 	2. Runnable - when the start method has being called on the thread object the thread is know be in a runnable state
 * 	3. Running - when the thread has been giving priority by the scheduler and is executing
 * 	4. Blocked - when the thread cannot execute because of a pending requirement has not yet been met
 *  5. Dead - when the run() method has completed the Thread is known to be in a dead state and cannot be called again for execution
 */

package com.threads;

public class MyFirstThreadExample implements Runnable { // extend the Runnable interface		
	public synchronized void run() { // override the run method & apply the synchronized access modifier for thread safety
		for(int i=0; i<5; i++) { // print the name of the current executing thread and a count number
			System.out.println(Thread.currentThread().getName() + 
					" Count No : " + i);	
			try {
				Thread.sleep(1000); // sleep for one second after the print out
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyFirstThreadExample r1 = new MyFirstThreadExample(); // create 3 Objects of my class which IS-A Runnable
		MyFirstThreadExample r2 = new MyFirstThreadExample();
		MyFirstThreadExample r3 = new MyFirstThreadExample();
		
		Thread t1 = new Thread(r1, "One"); // pass the Runnable objects along with the thread name while instantiating each new thread Object
		Thread t2 = new Thread(r2, "Two");
		Thread t3 = new Thread(r3, "Three");
		
		t1.start(); // apply the start method to each thread transitioning the thread objects into a runnable state
		t2.start();
		t3.start();	
	}	
}





