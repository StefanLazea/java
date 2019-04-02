package ro.ase.java.models;

import java.io.Serializable;

public class Coffee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String beverageName;
	private String coffeeType;
	private double price;
	
	public Coffee() {
		
	}
	
	public Coffee(String name, String type, double price) {
		this.beverageName = name;
		this.coffeeType = type;
		this.price = price;
	}

	public String getBeverageName() {
		return this.beverageName;
	}

	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}

	public String getCoffeeType() {
		return this.coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.getBeverageName() + " and "
				+ this.getCoffeeType() 
				+ " price: " + this.getPrice();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Coffee)) {
			return false;
		}
		Coffee c = (Coffee) o;
		return this.beverageName.equals(c.getBeverageName());
	}
	
	//pentru unicitatea de la Set
	@Override
	public int hashCode() {
		//toate produsele care au acelasi nume si acelasi pret vor fi considerate duplicat
		return 31*31 + this.beverageName.hashCode() + (int)this.price;
	}
}
