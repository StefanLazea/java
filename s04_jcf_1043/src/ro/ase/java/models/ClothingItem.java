package ro.ase.java.models;

public class ClothingItem implements Cloneable, Comparable<ClothingItem> {
	private String brand;
	private String type;
	private String size;
	private double price;
	
	public ClothingItem() {
		//constructor default
	}
	public ClothingItem(String brand, String type, String size, double price) {
		this.brand=brand;
		this.type=type;
		this.size=size;
		this.price=price;
	}
	
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setSize(String size) {
		this.size=size;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	public String getBrand() {
		return this.brand;
	}
	public String getType() {
		return this.type;
	}
	public String getSize() {
		return this.size;
	}
	public double getPrice() {
		return this.price;
	}
	
	@Override
	//Suprascriere
	public String toString() {
		return this.brand+" "+this.type+" "+this.size+" "+this.price;
	}
	
	@Override
	public ClothingItem clone() throws CloneNotSupportedException  {
		ClothingItem c=null;
		c=(ClothingItem)super.clone();
		if(this.brand!= null) c.brand=this.brand;
		if(this.type!=null)c.type=this.type;
		if(this.size!=null) c.size=this.size;
		c.price=this.price;
		return c;
	}
	@Override
	public int compareTo(ClothingItem o) {
		if(this.price==o.price) 
			return 0;
		else if(this.price>o.price)
			return 1;
		else
			return -1;
	}
	
	@Override
	public  boolean equals(Object o) {
		if (!(o instanceof ClothingItem))
			return false;
		ClothingItem ci=(ClothingItem)o;
			return this.brand.equals(ci.brand) && 
					this.type.equals(ci.type)&&
					this.size.equals(ci.size)&&
					this.price==ci.price;
		
	}
	
	@Override
	public int hashCode() {
		return 0;
		//folosit atunci cand adaugam elemente in colectie de tip hashmapuri pt a pastra unicitatea elementelor
	}

}
