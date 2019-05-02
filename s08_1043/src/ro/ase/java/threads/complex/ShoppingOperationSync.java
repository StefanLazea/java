package ro.ase.java.threads.complex;

public class ShoppingOperationSync implements Runnable {

	private int familyFunds = 50;
	//public static final Object lock = new Object();
	
	public void buy(int amount) {
		//ca atunci cand un thread utilizeaza acest cod, sync se asigura sa nu mai fie utilizat
		//folosim this, ca ne folosim de aceeasi clasa in application
		synchronized (this) {
			if(this.familyFunds >= amount) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.familyFunds -= amount;
				System.out.println(Thread.currentThread().getName() 
						+ " made a sync operation of " + amount 
						+ " . Total balance left: " +  this.familyFunds);
				
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buy(i);
		}
	}
}
