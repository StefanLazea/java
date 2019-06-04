package ro.ase.java;

public class Application {

	public static void main(String[] args) {
		Product p1=new Product("Iphone XR");
		//shallow copy
		Product p2=p1;
		//deep copy folosind clone
		Product p3=p1.clone();
		p2.setProductName("Iphone XS");
		p3.setProductName("Samsung Galaxy S10");
		
		System.out.println(p1.getProductName());
		System.out.println(p2.getProductName());	
		System.out.println(p3.getProductName());
	}

}
//mecanismul de clone