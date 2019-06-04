package ro.ase.java;

public class Product implements Cloneable {
	private String productName;
	
	public Product()
	{
		
	}
	
	public Product(String name)
	{
		this.productName=name;
	}
	public void setProductName(String name)
	{
		this.productName=name;
	}
	public String getProductName()
	{
		return this.productName;
	}
	
	public Product clone()
	{
		Product p=null;
		try {
			p=(Product) super.clone();  // apeleaza clone din Object
			p.setProductName(this.productName);
		} catch(CloneNotSupportedException ex)
		{
			ex.printStackTrace();
		}
		return p;
	}
}
