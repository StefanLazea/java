package ro.ase.java.models;

public class Coffee {
	private String beverageName;
	private String coffeeType;
	private double price;
	
	public Coffee() {
		
	}
	public Coffee( String name, String type, double price) {
		this.beverageName=name;
		this.coffeeType=type;
		this.price=price;
	}
	
	public void seBeverageName(String name) {
		this.beverageName=name;
	}
	public void setCoffeType(String type) {
		this.coffeeType=type;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	public String getBeverageName() {
		return this.beverageName;
	}
	public String getCoffeeType() {
		return this.coffeeType;
	}
	public double getPrice() {
		return this.price;
	}
	
}
