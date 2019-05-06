package ro.ase.java;

public class Application {
	public static void main(String [] args) {
		Vehicle v = new Vehicle();
		v.setName("Mercedes");
		v.setPrice(100000);
		
		Vehicle v3 = v.clone();
		Vehicle v2 = v;
		
		v2.setName("BMW");
		v3.setName("Nissan");
		
		System.out.println(v.getName());
		System.out.println(v2.getName());
		System.out.println(v3.getName());
	}
}
