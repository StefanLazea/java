package ro.ase.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ro.ase.java.threads.ArrayTask;
import ro.ase.java.threads.ArrayTaskFuture;

public class Application {
	private static final int NUMBER_OF_ELEMENTS = 100000000;
	private static final int NUMBER_OF_THREADS = 10;
	
	public static void main(String[] args) {	
		int[] values = new int[NUMBER_OF_ELEMENTS];
		for(int i=0; i<NUMBER_OF_ELEMENTS; i++) {
			values[i] = (int) Math.round(Math.random() * 100);
		}
		
		//fac un vector de thread-uri
		ExecutorService threadPool = 
				Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		ArrayTask[] tasks = new ArrayTask[NUMBER_OF_THREADS];
		
//		for(int i=0; i<NUMBER_OF_THREADS; i++) {
//			int start = i * (NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS); //batch
//			int end = (i+1) * (NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS); // ca o sa am final ca 200, 400...
//			
//			tasks[i] = new ArrayTask(values, start, end);
//			threadPool.execute(tasks[i]); //ptr a executa metoda run
//		}
	
		//threadPool.shutdown();
		
		//prin future obtin o valoare din thread, dupa ce se executa call-ul
		Future<Long>[] futures = new Future[NUMBER_OF_THREADS];
		for(int i=0; i<NUMBER_OF_THREADS; i++) {
			int start = i * (NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS); //batch
			int end = (i+1) * (NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS); // ca o sa am final ca 200, 400...
			Callable<Long> task = new ArrayTaskFuture(values, start, end);
			
			Future<Long> futureValues = threadPool.submit(task);
			futures[i] = futureValues;
		}
		
//		for(int i=0;i<NUMBER_OF_THREADS;i++) {
//			System.out.println(tasks[i].getSum());
//		}
//		
		System.out.println("FUTURE IMPL: ");
		for(int i=0;i<NUMBER_OF_THREADS;i++) {
			try {
				System.out.println(futures[i].get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
