package ro.ase.java;

import ro.ase.java.threads.complex.ShoppingOperation;
import ro.ase.java.threads.complex.ShoppingOperationSync;
import ro.ase.java.threads.simple.RunnableThread;
import ro.ase.java.threads.simple.SimpleThread;

public class Application {

	public static void main(String[] args) {
//		SimpleThread t1 = new SimpleThread("Thread 1");
//		SimpleThread t2 = new SimpleThread("Thread 2");
//
//		t1.start();
//		t2.start();
//	
//		//Thread t3 = new Thread(target);
//		//metoda 2
//
//		RunnableThread r1 = new RunnableThread();
//		Thread t3 = new Thread(r1, "Thread 3");
//		Thread t4 = new Thread(r1, "Thread 4");
//		
//		t3.start();
//		t4.start();
//
//		//creating threads using anonymous class
//		//declare an anonymous class
//		Runnable r2 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Executing from anonymous runnable from: "
//						+ Thread.currentThread().getName());
//			}
//		};
//		
//		Thread t5 = new Thread(r2, "Thread 5");
//		Thread t6 = new Thread(r2, "Thread 6");
//		
//		t5.start();
//		t6.start();
//		
//		//creating threads using lambda expression
//		Runnable r3 = ()->{
//			System.out.println("Executing from lambda expression "
//							+ Thread.currentThread().getName());
//		};
//		
//		Thread t7 = new Thread(r3, "Thread 7");
//		Thread t8 = new Thread(r3, "Thread 8");
//		
//		t7.start();
//		t8.start();
//		
//		ShoppingOperation op1 = new ShoppingOperation();
//		Thread t1 = new Thread(op1, "Wife");
//		Thread t2 = new Thread(op1, "Husband");
//		
//		t1.start();
//		t2.start();
//		
		ShoppingOperationSync sop2 = new ShoppingOperationSync();
		Thread t3 = new Thread(sop2, "Wife");
		Thread t4 = new Thread(sop2, "Husband");
		
		t3.start();
		t4.start();
		
	}

}
