package ro.ase.java.threads;

import java.util.concurrent.Callable;

public class ArrayTaskFuture implements Callable<Long> {

	private int[] values;
	private int startIndex;
	private int endIndex;
	
	public ArrayTaskFuture(int[] values, int start, int end) {
		this.values = values;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	@Override
	public Long call() throws Exception {
		long sum = 0;
		
		for(int i = this.startIndex; i<this.endIndex; i++) {
			sum += this.values[i];
		}
		
		return Long.valueOf(sum); //boxing & unboxing; se face explicit aici castul
	}

}
