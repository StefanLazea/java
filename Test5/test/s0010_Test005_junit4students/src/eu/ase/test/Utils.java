package eu.ase.test;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eu.ase.test.VipPassenger;

/*
 * Grade 5: Create the class Utils.
 * 
 * The class Utils has the following private fields:
 * matrix: Object[][] for the references to the VipPassenger objects stored within the matrix objects
 * 
 * Additionally, there the following private fields used for the intermediary results:
 *  listPassengers of type List<Passenger>;
 *  streamPassenger of type Stream<Passenger>;
 *  predicate of type Predicate<Passenger>;
 *  threadsArrayWorkerTasks of type MyR[];
 * 
 * The class has no constructor - besides the default constructor (without parameters) 
 * automatically added by Java
 * 
 * Implement proper get/set method(s) for all fields:
 * (listPassengers, streamPassenger, predicate, threadsArrayWorkerTasks)
 * The set method for matrix field (public void setMatrix(Object[][] matrixInstance) throws Exception)
 * is setting the matrix field with a deep clone of matrixInstance by applying clone method
 * for each element of the matrixInstance (and each element from matrixInstance is casted to VipPassenger class).
 * 
 * Create method displayMatrix() -> void which put on the screen the content of the matrix field
 * 
 * Grade 6: Create public methods:
 *  writeBinary(String file) which returns void and serialize the matrix field into a file; 
 *  hint: 
 *  save the lines and columns of the matrix as first 2 integer values in file; 
 *  each object from the matrix is from class VipPassenger
 *  
 *  readBinary(String file) which returns void and restore/de-serialize the objects into matrix field from a file; 
 *  hint: 
 *  read the lines and columns of the matrix as first 2 integer values from file; 
 *  each object from the matrix is from class VipPassenger
 *  
 *  
 * 1 point (Grade 6 must be resolved completely from 2 to 6):
 *  Implement the public method transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() 
 *  which returns List<VipPassenger>
 *  which transform the matrix into an ArrayList<VipPassenger> and then, 
 *  sort the passengers and filter them by using lambda function as predicate within filter function
 *  and returns the new sorted list by using functional processing streams.
 *  This method must set consistently the intermediary fields:
 *  this.streamPassenger, this.listPassengers and this.predicate
 *  and returns the sorted list of the adults (age > 18) which are objects from VipPassenger
 *  
 * 1 point (Grade 6 must to be resolved completely from 2 to 6):
 *  Implement public method calculateAverageAge() without parameters which is returning the average age of the passengers
 *  and public method calculateAverageAgeMultiThreading() which use multi-threading or Executor-Service mechanism/framework
 *  for creating worker tasks using the field: this.threadsArrayWorkerTasks of type MyR[] 
 *  Class MyR implements Runnable and proper implementation of this class => +2 points 
 *  The method calculateAverageAgeMultiThreading() calculates the average of the age by using 
 *  the number of worker tasks / threads equals to the number of the lines from the matrix.
 *  This method uses the field this.threadsArrayWorkerTasks
 */


/*
 * Nota 5: Creati clasa Utils.
 * 
 * The clasa are urmatoarele campuri private:
 * matrix: Object[][] pentru containerul ce stocheaza referinte de tip VipPassenger catre obiectele matricei
 * 
 * Aditional, urmatoarele campuri private ale clase sunt utilizate pentru rezultate intermediare:
 *  listPassengers de tip List<Passenger>;
 *  streamPassenger de tip Stream<Passenger>;
 *  predicate de tip Predicate<Passenger>;
 *  threadsArrayWorkerTasks de tip MyR[];
 * 
 * Clasa nu are constructori
 * 
 * Implementati corespunzator metodele get/set pentru toate campurile:
 * (listPassengers, streamPassenger, predicate, threadsArrayWorkerTasks)
 * Metoda set pentru campul matrix (public void setMatrix(Object[][] matrixInstance) throws Exception)
 * seteaza campul marix cu o clona profunda (deep clone) a parametrului matrixInstance 
 * prin aplicarea medodei clone fiecarui obiect din matrixInstance 
 * (se aplica cast-ul la clasa VipPassenger pentru fiecare obiect)
 * 
 * Creati metoda displayMatrix() -> void ce afiseaza pe ecran matricea (continutul textual al campului matrix pe ecran)
 * 
 * Nota 6: Creati metodele publice:
 *  writeBinary(String file) -> void ce serializeaza campul matrice in fisier; 
 *  indicii: 
 *  se salveaza numarul de linii si coloane ale campului matrix ca 2 valori intregi in fisier; 
 *  fiecare obiect din matrice este din clasa VipPassenger
 *  
 *  readBinary(String file) -> void ce restaureaza/de-serializeaza obiecte din fisier in matrice (campul matrix); 
 *  indicii: 
 *  se citesc liniile si coloanele matricei ca primele 2 valori intregi din fisier; 
 *  fiecare obiect din matrice este din clasa VipPassenger
 *  
 *  
 * 1 punct (Nota 6 se rezolva complet si incremental de la 2 la 6):
 *  Implementati metoda publica: transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() 
 *  ce returneaza un obiect de tip List<VipPassenger>
 *  Aceasta metoda transforma/liniarizeaza matricea intr-un obiect din ArrayList<VipPassenger> si apoi, 
 *  sorteaza pasagerii si-i filtreaza utilizand ca predicat functii lambda in cadrul 
 *  fluxurile functionale de procesare (functional processing streams).
 *  Aceasta metoda trebuie sa seteze consistent campurile urmatoare din interiorul clasei:
 *  this.streamPassenger, this.listPassengers si this.predicate
 *  si returneaza lista sortata a adultilor (age > 18) ce sunt obiecte din clasa VipPassenger
 *  
 * 1 punct (Nota 6 se rezolva complet si incremental de la 2 la 6):
 *  Implementati metoda calculateAverageAge() ce returneaza media varstei pasagerilor
 *  Apoi, implementati calculateAverageAgeMultiThreading() ce creaza mai multe fire de executie sau
 *  conlucreaza cu mecanismul Executor-Service pentru crearea de task-uri cu ajutorul campului:
 *  this.threadsArrayWorkerTasks de tip MyR[]
 *  Clasa MyR implementeaza interfata Runnable iar implementare corespunzatoare a clasei MyR => +2 points 
 *  Metoda calculateAverageAgeMultiThreading() calculeaza media de varsta prin utilizarea unui numar 
 *  de "worker tasks" / "threads" - fire de executie egal cu numarul de linii ale matricei.
 *  Aceasta metoda utilizeaza campul: this.threadsArrayWorkerTasks
 	listPassengers, streamPassenger, predicate, threadsArrayWorkerTasks
 */

public class Utils {

	private Object[][]matrix;
	private List<VipPassenger> listPassengers;
	private Stream<VipPassenger> streamPassenger;
	private Predicate<Passenger> predicate;
	private MyR[] threadsArrayWorkerTasks;
	
	
	public Object[][] getMatrix() {
		return this.matrix;
	}
	
	public void setMatrix(Object[][] matrixInstance) throws Exception{
		
		this.matrix = matrixInstance.clone();
			
	}
	
	public List<VipPassenger> getListPassengers() {
		return listPassengers;
	}
	
	public void setListPassengers(List<VipPassenger> listPassengers) {
		this.listPassengers = listPassengers;
	}
	
	public Stream<VipPassenger> getStreamPassenger() {
		return streamPassenger;
	}
	
	public void setStreamPassenger(Stream<VipPassenger> streamPassenger) {
		this.streamPassenger = streamPassenger;
	}
	
	public Predicate<Passenger> getPredicate() {
		return predicate;
	}
	
	public void setPredicate(Predicate<Passenger> predicate) {
		this.predicate = predicate;
	}
	
	public MyR[] getThreadsArrayWorkerTasks() {
		return threadsArrayWorkerTasks;
	}
	
	public void setThreadsArrayWorkerTasks(MyR[] threadsArrayWorkerTasks) {
		this.threadsArrayWorkerTasks = threadsArrayWorkerTasks;
	}
	
	public void displayMatrix() {
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	public void writeBinary(String file){
		
		ObjectOutputStream outo;
		
		try {
			outo= new ObjectOutputStream(new FileOutputStream(file));
			outo.writeInt(this.matrix.length);
			outo.writeInt(this.matrix[0].length);
			
			for(int i=0; i<this.matrix.length; i++) {
				for(int j=0; j<this.matrix[0].length; j++) {
					outo.writeObject(this.matrix[i][j]);
				}
			}
			
			
			outo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void readBinary(String file) {
		
		int l;
		int c;
		ObjectInputStream in;
		
		try {
			in=new ObjectInputStream(new FileInputStream(file));
			l=in.readInt();
			c=in.readInt();
			this.matrix=new Object[l][c];
			
			for(int i=0; i<l; i++) {
				for(int j=0; j<c; j++) {
					this.matrix[i][j]=in.readObject();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	public float calculateAverageAge() {
		float s=0;
		
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[0].length; j++) {
				VipPassenger p = (VipPassenger) this.matrix[i][j];
				s+=p.getAge();
			}
		}
		return s/(this.matrix.length+1+this.matrix[0].length);
	}

	
	public float calculateAverageAgeMultiThreading() {
		final int THREADS=this.matrix.length;
		float s=0;
		Thread array[] = new Thread[THREADS];
		this.threadsArrayWorkerTasks=new MyR[THREADS];
		
		for(int i=0; i<THREADS; i++) {
			
				this.threadsArrayWorkerTasks[i]= new MyR(this.matrix, i);
				array[i]=new Thread(this.threadsArrayWorkerTasks[i]);
		}
		
		for(int i=0; i<THREADS; i++) {
			array[i].start();
		}
		
		for(int i=0; i<THREADS; i++) {
			try {
				array[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<THREADS; i++) {
			s+=this.threadsArrayWorkerTasks[i].getAvg();
		}
		
		return s/(this.matrix.length-(THREADS+1)+this.matrix[0].length);
	}
	
	/*

 *  Implementati metoda publica: transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() 
 *  ce returneaza un obiect de tip List<VipPassenger>
 *  Aceasta metoda transforma/liniarizeaza matricea intr-un obiect din ArrayList<VipPassenger> si apoi, 
 *  sorteaza pasagerii si-i filtreaza utilizand ca predicat functii lambda in cadrul 
 *  fluxurile functionale de procesare (functional processing streams).
 *  Aceasta metoda trebuie sa seteze consistent campurile urmatoare din interiorul clasei:
 *  this.streamPassenger, this.listPassengers si this.predicate
 *  si returneaza lista sortata a adultilor (age > 18) ce sunt obiecte din clasa VipPassenger
	 */
	public List<VipPassenger> transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() {
		List<VipPassenger> al = new ArrayList<VipPassenger>();
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[0].length; j++) {
				al.add((VipPassenger) this.matrix[i][j]);
			}
		}
		
		this.predicate=pass -> pass.getAge()>18;
		this.streamPassenger=al.stream().sorted();
		this.listPassengers=this.streamPassenger.filter(this.predicate).collect(Collectors.<VipPassenger>toList());
		return this.listPassengers;
	}
	
}