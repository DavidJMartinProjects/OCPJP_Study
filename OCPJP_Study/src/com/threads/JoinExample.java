package com.threads;

public class JoinExample {
	public static void main(String[] args) {
		RunnableOne r1 = new RunnableOne(); // create and instantiate two runnable Objects
		RunnableTwo r2 = new RunnableTwo();
		
		Thread t1 = new Thread(r1, "Thread One"); // create two Thread Objects passing the runnable object and Thread name as arguments
		Thread t2 = new Thread(r2, "Thread Two");
		
		t1.start(); // start t1 thread		
		
		try {
			t1.join(); // ensure that thread t1 completes before thread t2 commences using the join() method
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start(); // start t2 thread		
	}
}

class RunnableOne implements Runnable { // implement the Runnable interface
	public void run() { // override the run method from the Runnable interface
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Count : " +i); // print thread name and a count variable
		}
	}
}

class RunnableTwo implements Runnable { // implement the Runnable interface
	public void run() { // override the run method from the Runnable interface
		for(int k=0; k<5; k++) {
			System.out.println(Thread.currentThread().getName() + " - Count : " +k); // print thread name and a count variable
		} 
	}
}
