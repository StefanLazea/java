package ro.ase.java.threads.simple;

public class RunnableThread implements Runnable{
	//runnable are o metoda, si e o interfata functionala
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Executing from runnable class "
		+ Thread.currentThread().getName());
	}

}
