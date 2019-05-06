package ro.ase.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ro.ase.java.models.Telephone;

public class FileUtils {

	public FileUtils() {
		
	}
	
	public void saveDepositInTextFile(List<Telephone> deposit, String fileName) throws IOException {
		File f = new File(fileName);
		
		FileWriter writer = new FileWriter(f);
		for(Telephone t : deposit) {
			writer.write(t.getMake() + "," + t.getType() + "," + t.getPrice() +"\n");
		}
		
		writer.close();
		System.out.println("The deposit has been written to the file: " + fileName);
	}
	
	public Map<String, Integer> readDepositFromTextFile(String fileName) throws IOException{
		Map<String, Integer> depositDetails = new HashMap<>();
		
		File f = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		
		String line = "";
		while((line=reader.readLine())!=null) {
			String[] values = line.split(",");
			if(depositDetails.containsKey(values[0])) {
				depositDetails.put(values[0], depositDetails.get(values[0])+1);
			} else {
				depositDetails.put(values[0], 1);
			}
		}
		reader.close();
		return depositDetails;	
	}
	
	public void writeDepositSerialize(List<Telephone> deposit, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Telephone t : deposit) {
			oos.writeObject(t);
		}
		oos.close();
		fos.close();
	}
	
	public List<Telephone> readDepositDeserialize(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Telephone> lista = new ArrayList<>();

		while(true) {
			try {
				Telephone t = (Telephone) ois.readObject();
				lista.add(t);
			}catch(EOFException e) {
				break;
			}
		}
		
		fis.close();
		ois.close();
		return lista;
		
	}
	
	public void writeDepositInBinaryFormat(List<Telephone> deposit, String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeInt(deposit.size());
		for(Telephone t:deposit) {
			dos.writeUTF(t.getMake());
			dos.writeUTF(t.getType());
			dos.writeFloat(t.getPrice());
		}
		fos.close();
		dos.close();
	}
	
	public void readDepositFromBinaryFile(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		
		int noObjects = dis.readInt();
		for(int i=0;i<noObjects;i++) {
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
		}
		fis.close();
		dis.close();
	}
}