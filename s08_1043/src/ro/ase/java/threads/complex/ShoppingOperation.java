package ro.ase.java.threads.complex;

public class ShoppingOperation implements Runnable{

	private int familyFunds = 50;
	
	public void buy(int amount) {
		if(familyFunds >= amount) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.familyFunds -= amount;
			System.out.println(Thread.currentThread().getName() 
					+ " made a transaction of " + amount 
					+ ". Total balance left: " + this.familyFunds);
		}
	}
			
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			buy(i);
		}
	}

}
