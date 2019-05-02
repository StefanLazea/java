package ro.ase.java.threads;

public class ArrayTask implements Runnable {
	
	private int[] values;
	private int startIndex;
	private int endIndex;
	private long sum;
	
	public ArrayTask(int[] values, int start, int end) {
		this.values = values;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	//dezavantaj, nu returneaza; pentru callback
	@Override
	public void run() {
		long s = 0;
		for(int i=this.startIndex; i<this.endIndex; i++) {
			s+= this.values[i];
		}
		this.sum = s;
	}
	
	public long getSum() {
		return this.sum;
	}

}
