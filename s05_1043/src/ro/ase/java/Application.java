package ro.ase.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ro.ase.java.models.Coffee;
import ro.ase.java.utils.CoffeeShopUtils;

public class Application {
	public static void main(String[] args) 
	{
		//lucru cu fisiere
		//Aplicatie pt gestiunea unei cafenele
		
		Coffee c1= new Coffee("Cafe Latte", "GUATEMALA", 16.5);
		Coffee c2= new Coffee("Cappuccino","ETIOPIA", 15);
		Coffee c3= new Coffee("Flat White", "ARABICA", 13);
		Coffee c4= new Coffee("Flat White", "ARABICA", 13);
		Coffee c5= new Coffee("Flat White", "ARABICA", 13);
		Coffee c6= new Coffee("Flat White", "ARABICA", 13);
		Coffee c7= new Coffee("Flat White", "ARABICA", 13);
		Coffee c8= new Coffee("Flat White", "ARABICA", 13);
		
		//trebuie importate ArrayList si List
		List<Coffee> order= new ArrayList<>();
		order.add(c1);
		order.add(c2);
		order.add(c3);
		order.add(c4);
		order.add(c5);
		order.add(c6);
		order.add(c7);
		order.add(c8);
		
		CoffeeShopUtils utils=new CoffeeShopUtils();
		utils.displayOrderDetails(order);
		
		try {
			utils.saveOrderDetailsInTextFile(order, "coffee.txt");
			Map<String, Integer> orderDetails=utils.getOrderDetailsFromTextFile("coffee.txt");
			System.out.println("Parcurgere map dupa citire din fisier text.");
			for(Entry<String, Integer> entry : orderDetails.entrySet()) {
				System.out.println(entry.getKey()+": "+entry.getValue());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
