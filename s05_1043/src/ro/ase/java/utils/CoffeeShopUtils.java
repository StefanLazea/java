package ro.ase.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ro.ase.java.models.Coffee;

public class CoffeeShopUtils {
	public CoffeeShopUtils() {
		
	}
	public void displayOrderDetails(List<Coffee> order) {
		double TotalPrice=0;
		for(Coffee coffee : order) {
			System.out.println(coffee.getBeverageName()+" "+coffee.getCoffeeType()+" "+coffee.getPrice());
			TotalPrice+=coffee.getPrice();
		}
		System.out.println("-----------------------------------");
		System.out.println("Total: "+TotalPrice);
	}
	

	
	public void saveOrderDetailsInTextFile(List<Coffee> order, String fileName) throws IOException {
		File file=new File(fileName);
		FileWriter writer=new FileWriter(file); 
		//ai nevoie de un fisier in care sa scrii cand initializezi un FileWriter
		for(Coffee coffee : order)
			writer.write(coffee.getBeverageName()+","+coffee.getCoffeeType()+","+coffee.getPrice()+"\n");
		writer.close();
		System.out.println("Comanda a fost scrisa in fisierul: "+fileName);

	}
//try catch cu surrounder-> pe beculet :D
	
	public Map<String, Integer> getOrderDetailsFromTextFile(String fileName) throws IOException{
		Map<String, Integer> order=new HashMap<>();
		//cheia o sa fie numele cafelei si integerul= numarul de cafele de acel tip
		File file=new File(fileName);
		FileReader fr= new FileReader(file);
		BufferedReader reader= new BufferedReader(fr);
		String line="";
		while((line=reader.readLine())!=null) {
			String[] values=line.split(",");
			if(order.containsKey(values[0])) {
				order.put(values[0], order.get(values[0])+1);
			} else {
				order.put(values[0],1);
			}
		}
		
		reader.close();
		
		return order;
		}
}
