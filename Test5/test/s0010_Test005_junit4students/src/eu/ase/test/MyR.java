package eu.ase.test;

/* 
 *  2 points (Grade 6 must be resolved completely from 3 to 6):
 *  Implement the public class MyR which implements Runnable interface
 *  The class contains the following private fields:
 *  v of type VipPassenger[] // classic array of the passengers
 *  avg of type float // the average of the elements from the passenger array in terms of age
 *  
 *  Implement the public constructor with 2 parameters:
 *  "m" of type Object[][], "line" of type int
 *  each element from the array of the class is reference to an object (column) from the line of the matrix received as parameters
 *  
 *  Override the run() method to be called in multi-threading environment for calculating the average age of the passengers
 *  and provide public method getAvg() which is returning the float average age (avg field from the class)
 */

/* 
 *  2 puncte (Nota 6 trebuie implementata cu punctajele incrementale de la 3 la 6):
 *  Dezvoltati clasa publica MyR care implementeaza interfata Runnable
 *  Clasa contine urmatoarele campuri private:
 *  v de tip VipPassenger[] // 
 *  avg de tip float // media varstei
 *  
 *  Implementati constructorul cu 2 parameteri:
 *  "m" de tip Object[][], "line" de tip int
 *  Fiecare element din campul v este referinta catre un obiect din poztia coresunzatoare (coloana) din linia matricei primite ca parmetru
 *  
 *  Supra-scrieti metoda run() pentru a fi apelata in mod multi-fir pentru calcularea mediei de varsta a pasagerilor
 *  si furnizati metoda publica getAvg() ce returneaza o valoare de tip float ce reprezinta media de varsta (campul avg)
 */

public class MyR implements Runnable  {

	private float avg;
	private VipPassenger[] v;
	
	public MyR(Object[][] m, int line) {
		
		
		this.v=new VipPassenger[m[line].length];
		for(int i=0; i<m[line].length; i++) {
			v[i]=(VipPassenger) m[line][i];
		}
	}
	
	@Override
	public void run() {
		
		float s = 0;
		
		for(int i=0; i<this.v.length; i++) {
			s+=this.v[i].getAge();
		}
		this.avg=s/this.v.length;
		
	}

	public float getAvg() {
		return this.avg;
	}
	
	

}
