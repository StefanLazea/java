package ro.ase.java;

public class Vehicle implements Cloneable{
	private String name;
	private double price;
		
	public Vehicle() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public Vehicle clone() {
		Vehicle t = null;
		
		try {
			t = (Vehicle) super.clone();
			t.name = this.name;
			t.price = this.price;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return t;
	}
}
