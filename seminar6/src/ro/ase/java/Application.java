package ro.ase.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ro.ase.java.models.Coffee;
import ro.ase.java.utils.FileUtils;

public class Application {

	public static void main(String[] args) {
		Coffee a1 = new Coffee("Nope", "nope", 10);
		Coffee a2 = new Coffee("Cappucino", "Columbia", 40);
		Coffee a3 = new Coffee("Nope2", "nope2", 20);
		Coffee a4 = new Coffee("Cappucino", "Columbia", 40);
		Coffee a5 = new Coffee("Cappucino", "Columbia", 40);

		List<Coffee> order = new ArrayList<>();
		FileUtils utils = new FileUtils();
		
		order.add(a1);
		order.add(a2);
		order.add(a3);
		order.add(a4);
		order.add(a5);
		
		try {
			utils.writeOrderBinary("coffee1.txt", order);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			List<Coffee> newOrderList = utils.readerOrderFromBinary("coffee1.txt");
			System.out.println("Read from binary file");
			for (Coffee coffee : newOrderList) {
				System.out.println(coffee.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			utils.serializeOrder("coffee2.txt", order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Coffee> orderDeserialize = utils.deserializeOrder("coffee2.txt");
			Set<Coffee> uniqueCoffees = new HashSet<>();
						
			System.out.println("Deserialize");
			for(Coffee c : orderDeserialize) {
				System.out.println(c.toString());
				uniqueCoffees.add(c);
			}
			
			System.out.println("--------------------------------------");
			for(Coffee c : uniqueCoffees) {
				System.out.println(c);
			}
			
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
