package ro.ase.models;

import java.util.List;

public class Dealer {
	private String location;
	private List<Vehicle> listaMasini;
	
	public Dealer(String location) {
		this.location = location;
	}
	
	public List<Vehicle> getItems(){
		return this.listaMasini;
	}
	
	public void addItem(Vehicle c) {
		this.listaMasini.add(c);
	}
}
