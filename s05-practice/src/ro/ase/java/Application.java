package ro.ase.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ro.ase.java.io.FileUtils;
import ro.ase.java.models.Telephone;

public class Application {
	public static void main(String[] args) {
		List<Telephone> deposit = new ArrayList<>();

		Telephone t1 = new Telephone("Samsung", "Fold", 1000);
		Telephone t2 = new Telephone("IPhone", "XR", 999);	
		Telephone t3 = new Telephone("IPhone", "XS", 899);
		Telephone t4 = new Telephone("IPhone", "XR", 999);	

		deposit.add(t1);
		deposit.add(t2);
		deposit.add(t3);
		deposit.add(t4);
		deposit.add(t3);

		
		for(Telephone e: deposit) {
			System.out.println(e.toString());
		}
		
		FileUtils fu = new FileUtils();
		
		try {
			fu.saveDepositInTextFile(deposit, "deposit.txt");
			
			Map<String, Integer> details = fu.readDepositFromTextFile("deposit.txt");
			for(Entry<String, Integer> entry : details.entrySet()) {
				System.out.println(entry.getKey() + " -- " + entry.getValue());
			}
			
			fu.writeDepositSerialize(deposit, "serialize.txt");
			
			System.out.println("Deposit was wrote in binary format");
			fu.writeDepositInBinaryFormat(deposit, "binary.dat");
			
			System.out.println("Reading from .dat file");
			fu.readDepositFromBinaryFile("binary.dat");
			
			try {
				System.out.println("Deserializare: ");
				for(Telephone t: fu.readDepositDeserialize("serialize.txt")) {
					System.out.println(t);
				}
				
				System.out.println("Deserialize data from a set");

				//hashset for unique entries
				Set<Telephone> unique = new HashSet<>();
				for(Telephone t: fu.readDepositDeserialize("serialize.txt")) {
					unique.add(t);
				}
				
				for(Telephone t: unique) {
					System.out.println(t);
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
