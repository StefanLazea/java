package ro.ase.java.models;

import java.io.Serializable;

public class Telephone implements Serializable{

	private String make;
	private String type;
	private float price;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public Telephone() {
		
	}
	
	public Telephone(String make, String type, float price) {
		this.make = make;
		this.type = type;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.make + " " + this.type + " " + this.price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Telephone)) {
			return false;
		}
		Telephone t = (Telephone) obj;
		return t.make.equals(this.make);
	}
	
	@Override
	public int hashCode() {
		return 31 * 31 * this.make.hashCode() + (int) this.price;
	}
}
