package ro.ase.models;

public class Vehicle implements Comparable<Vehicle>, Cloneable{
	
	private String model;
	private double price;
	private String energy;
	private double power;
	
	public Vehicle () {
		
	}
	
	public Vehicle(
			String model,
			String energy, 
			double price, 
			double power
	) {
		this.model = model;
		this.energy = energy;
		this.price = price;
		this.power = power;
	}

	//in momentul cand avem hashtable sau hashset si avem si equals definit
	
	@Override
	public int hashCode() {
		return 37 * 37 * (int) this.price * this.model.hashCode(); 
	}
	 
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
		
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle v = (Vehicle) obj;
		
		return 
				v.model.equals(this.model) &&
				v.energy.equals(this.energy) &&
				this.price == v.price &&
				this.power == v.power;
	}
	
	public Vehicle clone() throws CloneNotSupportedException {
		Vehicle c = (Vehicle) super.clone();
		if(this.model != null) {
			c.model = this.model;
		}
		if(this.energy != null) {
			c.energy = this.energy;
		}
		c.price = this.price;
		c.power = this.power;
		return c;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.model + " having " + this.power 
				+ "hp,  costs " + this.price 
				+ " and is powered with " + this.energy;
	}

	@Override
	public int compareTo(Vehicle o) {
		if(this.price == o.price) {
			return 0;
		} else if(this.price > o.price) {
			return 1;
		} 
		return -1;
	}
}
