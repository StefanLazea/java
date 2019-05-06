package ro.ase.java;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import ro.ase.models.Dealer;
import ro.ase.models.Vehicle;

public class Application {

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("sl500", "diesel", 20000, 290f);
		Vehicle v2 = new Vehicle("635ci", "gasoline", 20000, 208f);
		Vehicle v3 = new Vehicle("i3", "electricity", 40000, 100f);
		Vehicle v4 = new Vehicle("gle", "diesel", 300000, 660f);
		
		List<Vehicle> lista = new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		lista.add(v4);
		lista.add(v1);
		lista.add(v4);
		lista.sort(null);
		
		for(Vehicle vehicle : lista) {
			System.out.println(vehicle.toString());
		}
//
//		Dealer dealer = new Dealer("Pitesti");
//	
//		Vehicle v5 = new Vehicle("sl500", "diesel", 20000, 290f);
//
//		try{
//			dealer.addItem(v5);
//		}catch (NullPointerException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

		
		Map<Vehicle, String> listaLocatii = new Hashtable<Vehicle, String>();
		
		listaLocatii.put(v1, "Pitesti");
		listaLocatii.put(v3, "Bucuresti");
		
		for(Entry<Vehicle, String> entry : listaLocatii.entrySet()) {
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}
		
		Set<Vehicle> setList = new TreeSet<Vehicle>();
		setList.add(v2);
		setList.add(v3);
		
		for(Vehicle v : setList) {
			System.out.println(v);
		}
		
		Iterator<Vehicle> iterator = setList.iterator();
		
		while(iterator.hasNext()) {
			Vehicle v = iterator.next();
			System.out.println(v);
		}
	}

}
