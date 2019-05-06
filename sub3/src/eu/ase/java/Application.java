package eu.ase.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import eu.ase.java.models.Matrice;
import eu.ase.java.models.PasagerEc;
import eu.ase.java.models.PasagerVIP;

public class Application {

	public static void main(String[] args) {
		Matrice m = new Matrice();
		m.setNrLinii(2);
		m.setNrColoane(3);
		Object[][] matrix = new Object[4][8];
		PasagerVIP ps1 = new PasagerVIP("Bou", 1, 20, "12as35d4");
		PasagerVIP ps2 = new PasagerVIP("Toma", 4, 34, "8765r4");
		PasagerVIP ps3 = new PasagerVIP("mue", 3, 90, "43redqw");
		PasagerEc ec1 = new PasagerEc("Mue", 3, 14, "df7g8");
//		matrix[0][0] = ps1;
//		matrix[0][1] = ps2;
//		matrix[0][2] = ps3;
//		matrix[1][0] = ps2;
//		matrix[1][1] = ec1;
//		matrix[1][2] = ps3;
//

		m.setContainer(matrix);
//		System.out.println(m);
		try {
			m.readFromFile("pasageriec.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m);
		
			
		
		System.out.println("SERIALIZARE SI DESERIALIZARE");
		
		try {
			FileOutputStream fos = new FileOutputStream("serialize.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(m);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			FileInputStream fis = new FileInputStream("serialize.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Matrice m2 = (Matrice) ois.readObject();
			System.out.println(m2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
