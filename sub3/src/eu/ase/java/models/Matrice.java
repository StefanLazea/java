package eu.ase.java.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.StringTokenizer;

public class Matrice implements Comparable<Matrice>, Cloneable, Serializable{
	private int nrLinii;
	private int nrColoane;
	private Object[][] container;
	
	public static final long serialVersionUID = 2L;
	
	public Matrice() {
		
	}
	
	public Matrice(int nrLinii, int nrColoane, Object[][] container) {
		this.nrLinii = nrLinii;
		this.nrColoane = nrColoane;
		this.container = new Object[this.nrLinii][this.nrColoane];
		for(int i=0;i<this.nrLinii;i++) {
			for(int j=0;j<this.nrColoane;j++) {
				this.container[i][j] = container[i][j];
			}
		}
	}
	
	public int getNrLinii() {
		return nrLinii;
	}
	
	public void setNrLinii(int nrLinii) {
		this.nrLinii = nrLinii;
	}
	
	public int getNrColoane() {
		return nrColoane;
	}
	
	public void setNrColoane(int nrColoane) {
		this.nrColoane = nrColoane;
	}
	
	public Object[][] getContainer() {
		return container;
	}
	
	public void setContainer(Object[][] container) {
		this.container = container;
	}
	
	public int getNotNullElementsCount() {
		int counter = 0;
		for(int i=0;i<this.nrLinii;i++) {
			for(int j=0;j<this.nrColoane;j++) {
				if(this.container[i][j] != null) {
					counter++;
				}
			}
		}
		return counter;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Matrice)) {
			return false;
		}
		Matrice mat = (Matrice) obj;
		return mat.nrLinii == this.nrLinii &&
				mat.nrColoane == this.nrColoane &&
				mat.container.equals(this.container);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Matrice mat = (Matrice) super.clone();
		mat.nrColoane = this.nrColoane;
		mat.nrLinii = this.nrLinii;
		mat.container = new Object[this.nrLinii][this.nrColoane];
		
		for(int i=0;i<this.nrLinii;i++) {
			for(int j=0;j<this.nrColoane;j++) {
				container[i][j] = this.container[i][j];
			}
		}
		return mat;
	}

	@Override
	public int compareTo(Matrice o) {
		if(this.nrColoane == o.nrColoane) {
			return 0;
		}else if (this.nrColoane < o.nrColoane) {
			return -1;
		}
		return 1;
	}
	
	@Override
	public String toString() {
		String result = "Matricea cu " + this.nrColoane + " coloane si " + this.nrLinii + " linii: \n";
		for(int i=0;i<this.nrLinii;i++) {
			for(int j=0;j<this.nrColoane;j++) {
				result += container[i][j] + "    ";
			}
			result += "\n";
		}
		return result;
	}
	
	
	
	
	
	
	public void readFromFile(String fileName) throws IOException {
		
		try {
			File f = new File(fileName);
			FileReader reader = new FileReader(f);
			BufferedReader bf = new BufferedReader(reader);
			
			String line = null;
			while((line=bf.readLine())!=null) {
				StringTokenizer tokenz = new StringTokenizer(line, "#");
				String nume = tokenz.nextToken();
				String numarLoc = tokenz.nextToken();
				String varsta = tokenz.nextToken();
				String nrCard = tokenz.nextToken();
				
				if(fileName.equals("pasageriec.txt")) {
					PasagerEc pe = new PasagerEc(
								nume, 
								Float.parseFloat(numarLoc),
								Float.parseFloat(varsta),
								nrCard
								);
					
					int pozitieScaun = 0;
					for(int i=0;i<this.nrLinii;i++) {
						for(int j=0;j<this.nrColoane;j++) {
							pozitieScaun++;
							if(pozitieScaun==pe.getNumarLoc()) {
								this.container[i][j] = pe;
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
