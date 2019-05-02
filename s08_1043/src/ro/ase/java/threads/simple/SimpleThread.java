package ro.ase.java.threads.simple;

public class SimpleThread extends Thread{

	private String name;
	
	public SimpleThread(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Hello from: " + this.getName());
	}
}
