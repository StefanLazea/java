package ro.ase.java.utils;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ro.ase.java.models.Coffee;

public class FileUtils {

	public FileUtils() {
		
	}
	
	public void writeOrderBinary(String filename, List<Coffee> order) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		DataOutputStream dout = new DataOutputStream(fos);
		
		dout.writeInt(order.size());	
		for(Coffee coffee : order) {
			dout.writeUTF(coffee.getBeverageName());
			dout.writeUTF(coffee.getCoffeeType());
			dout.writeDouble(coffee.getPrice());
		}
		dout.close();
		System.out.println("Data save in binary format in: " + filename);
	}
	
	public List<Coffee> readerOrderFromBinary(String filename) throws IOException {
		List<Coffee> order = new ArrayList<>();
		FileInputStream fis = new FileInputStream(filename);
		DataInputStream input = new DataInputStream(fis);
		
		int numberOfElements = input.readInt();
		
		for(int i=0;i<numberOfElements;i++) {
			Coffee c = new Coffee();
			c.setBeverageName(input.readUTF());
			c.setCoffeeType(input.readUTF());
			c.setPrice(input.readDouble());
			order.add(c);
		}
		input.close();
				
		return order;
	}
	
	
	public void serializeOrder(String fileName, List<Coffee> order) throws IOException {
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		
		for(Coffee c: order) {
			oos.writeObject(c);
		}
		
		System.out.println("Datas have been serialize in the file: "+ fileName);
	}
	
	public List<Coffee> deserializeOrder(String fileName) throws IOException, ClassNotFoundException{
		List<Coffee> order = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//merge sa scriem si numarul de elemente in fisier pentru a ne folosi la deserializare
		while(true) {
			try {
				Coffee c = (Coffee)(ois.readObject());
				order.add(c);
			} catch(EOFException e) {
				break;  //ajunge la finalul fisierului
			}
		}
		
		return order;
		
	}
	

}
