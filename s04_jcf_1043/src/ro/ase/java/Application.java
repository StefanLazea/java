package ro.ase.java;

import java.util.ArrayList;
import java.util.List;

import ro.ase.java.models.ClothingItem;

public class Application {
	public static void main(String[] args)
	{
		ClothingItem c1=new ClothingItem("Zara","TSHIRT", "S",100);
		ClothingItem c2=new ClothingItem("Gucci","HOODIE", "XS",1000);
		ClothingItem c3=new ClothingItem("LV","JACKET", "S",800);
		ClothingItem c4=new ClothingItem("H&M","BELT", "S",50);
		ClothingItem c5=new ClothingItem("H&M","BELT", "S",50);
		//System.out.println(c1.getBrand()+" "+c1.getType()+" "+c1.getSize()+" "+c1.getPrice());

		//System.out.println(c1.getClass());// si hashcode
		//System.out.println(c1);
		//ctrl+shift+/ => comentarii
		//colectie -- List e Interfata din java.util
		//Implementari pt List: ArrayList, LinkedList
		//ArrayList- avantaj la accesare, acces direct asupra elementelor
		
		List<ClothingItem> items= new ArrayList<>();
		items.add(c1);
		items.add(c2);
		items.add(c3);
		items.add(c4);
		items.add(c5);
		
		System.out.println("Elementele inainte de sortare:");
		for(ClothingItem item: items) {
			System.out.println(item);
		}
		
		System.out.println("Elemntele dupa sortare:");
		items.sort(null);
		for(ClothingItem item: items) {
			System.out.println(item);
		}
	//	System.out.println(items.get(2));
		
		System.out.println("Elementele sunt egale:" + c5.equals(c4));
		System.out.println("Elementele sunt egale:" + c5.equals(c3));
		
	}
}
