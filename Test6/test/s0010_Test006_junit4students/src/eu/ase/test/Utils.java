package eu.ase.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eu.ase.test.PremiumSubscriber;

/*
 * Grade 5: Create the class Utils.
 * 
 * The class Utils has the following private fields:
 * matrix: Object[][] for the references to the PremiumSubscriber objects stored within the matrix objects
 * 
 * Additionally, there the following private fields used for the intermediary results:
 *  listSubscribers of type List<PremiumSubscriber>;
 *  streamSubscriber of type Stream<PremiumSubscriber>;
 *  predicate of type Predicate<PremiumSubscriber>;
 *  threadsArrayWorkerTasks of type MyR[];
 * 
 * The class has no constructor - besides the default constructor (without parameters) 
 * automatically added by Java
 * 
 * Implement proper get/set method(s) for all fields:
 * (listSubscribers, streamSubscriber, predicate, threadsArrayWorkerTasks)
 * The set method for matrix field (public void setMatrix(Object[][] matrixInstance) throws Exception)
 * is setting the matrix field with a deep clone of matrixInstance by applying clone method
 * for each element of the matrixInstance (and each element from matrixInstance is casted to PremiumSubscriber class).
 * 
 * Create method displayMatrix() -> void which put on the screen the content of the matrix field
 * 
 * Grade 6: Create public methods:
 *  writeBinary(String file) which returns void and serialize the matrix field into a file; 
 *  hint: 
 *  save the lines and columns of the matrix as first 2 integer values in file; 
 *  each object from the matrix is from class PremiumSubscriber
 *  
 *  readBinary(String file) which returns void and restore/de-serialize the objects into matrix field from a file; 
 *  hint: 
 *  read the lines and columns of the matrix as first 2 integer values from file; 
 *  each object from the matrix is from class PremiumSubscriber
 *  
 *  
 * 1 point (Grade 6 must be resolved completely from 2 to 6):
 *  Implement the public method transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate(float c) 
 *  which returns List<PremiumSubscriber>
 *  which transform the matrix into an ArrayList<PremiumSubscriber> and then, 
 *  sort the subscribers and filter them by using lambda function as predicate within filter function
 *  and returns the new sorted list by using functional processing streams.
 *  This method must set consistently the intermediary fields:
 *  this.streamSubscriber, this.listSubscribers and this.predicate
 *  and returns the sorted list of the subscribers with subscription cost greater then a certain cost 
 *  the subscribers are objects from PremiumSubscriber
 *  
 * 1 point (Grade 6 must to be resolved completely from 2 to 6):
 *  Implement public method calculateAverageSubscriptionCosts() without parameters which is returning the average age of the passengers
 *  and public method calculateAverageSubscriptionCostsMultiThreading() which use multi-threading or Executor-Service mechanism/framework
 *  for creating worker tasks using the field: this.threadsArrayWorkerTasks of type MyR[] 
 *  Class MyR implements Runnable and proper implementation of this class => +2 points 
 *  The method calculateAverageSubscriptionCostsMultiThreading() calculates the average of the age by using 
 *  the number of worker tasks / threads equals to the number of the lines from the matrix.
 *  This method uses the field this.threadsArrayWorkerTasks
 */


/*
 * Nota 5: Creati clasa Utils.
 * 
 * The clasa are urmatoarele campuri private:
 * matrix: Object[][] pentru containerul ce stocheaza referinte de tip PremiumSubscriber catre obiectele matricei
 * 
 * Aditional, urmatoarele campuri private ale clase sunt utilizate pentru rezultate intermediare:
 *  listSubscribers de tip List<PremiumSubscriber>;
 *  streamSubscriber de tip Stream<PremiumSubscriber>;
 *  predicate de tip Predicate<PremiumSubscriber>;
 *  threadsArrayWorkerTasks de tip MyR[];
 * 
 * Clasa nu are constructori
 * 
 * Implementati corespunzator metodele get/set pentru toate campurile:
 * (listPassengers, streamPassenger, predicate, threadsArrayWorkerTasks)
 * Metoda set pentru campul matrix (public void setMatrix(Object[][] matrixInstance) throws Exception)
 * seteaza campul marix cu o clona profunda (deep clone) a parametrului matrixInstance 
 * prin aplicarea medodei clone fiecarui obiect din matrixInstance 
 * (se aplica cast-ul la clasa PremiumSubscriber pentru fiecare obiect)
 * 
 * Creati metoda displayMatrix() -> void ce afiseaza pe ecran matricea (continutul textual al campului matrix pe ecran)
 * 
 * Nota 6: Creati metodele publice:
 *  writeBinary(String file) -> void ce serializeaza campul matrice in fisier; 
 *  indicii: 
 *  se salveaza numarul de linii si coloane ale campului matrix ca 2 valori intregi in fisier; 
 *  fiecare obiect din matrice este din clasa PremiumSubscriber
 *  
 *  readBinary(String file) -> void ce restaureaza/de-serializeaza obiecte din fisier in matrice (campul matrix); 
 *  indicii: 
 *  se citesc liniile si coloanele matricei ca primele 2 valori intregi din fisier; 
 *  fiecare obiect din matrice este din clasa PremiumSubscriber
 *  
 *  
 * 1 punct (Nota 6 se rezolva complet si incremental de la 2 la 6):
 *  Implementati metoda publica: transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() 
 *  ce returneaza un obiect de tip List<PremiumSubscriber>
 *  Aceasta metoda transforma/liniarizeaza matricea intr-un obiect din ArrayList<PremiumSubscriber> si apoi, 
 *  sorteaza abonatii si-i filtreaza utilizand ca predicat functii lambda in cadrul 
 *  fluxurile functionale de procesare (functional processing streams).
 *  Aceasta metoda trebuie sa seteze consistent campurile urmatoare din interiorul clasei:
 *  this.streamPassenger, this.listPassengers si this.predicate
 *  si returneaza lista sortata a abonatilor cu un cost de abonamen mai mare decat o limita
 *  abonatii sunt obiecte din clasa PremiumSubscriber
 *  
 * 1 punct (Nota 6 se rezolva complet si incremental de la 2 la 6):
 *  Implementati metoda calculateAverageSubscriptionCosts() ce returneaza media varstei pasagerilor
 *  Apoi, implementati calculateAverageSubscriptionCostsMultiThreading() ce creaza mai multe fire de executie sau
 *  conlucreaza cu mecanismul Executor-Service pentru crearea de task-uri cu ajutorul campului:
 *  this.threadsArrayWorkerTasks de tip MyR[]
 *  Clasa MyR implementeaza interfata Runnable iar implementare corespunzatoare a clasei MyR => +2 points 
 *  Metoda calculateAverageSubscriptionCostsMultiThreading() calculeaza media de varsta prin utilizarea unui numar 
 *  de "worker tasks" / "threads" - fire de executie egal cu numarul de linii ale matricei.
 *  Aceasta metoda utilizeaza campul: this.threadsArrayWorkerTasks
 */

public class Utils{
	
	private Object[][] matrix;
	private List<PremiumSubscriber> listSubscribers;
	private Stream<PremiumSubscriber> streamSubscriber;
	private Predicate<PremiumSubscriber> predicate;
	private MyR[] threadsArrayWorkerTasks;
	
	
	public List<PremiumSubscriber> getListSubscribers() {
		return listSubscribers;
	}
	public void setListSubscribers(List<PremiumSubscriber> listSubscribers) {

		this.listSubscribers.addAll(listSubscribers);
		
	}
	public Stream<PremiumSubscriber> getStreamSubscriber() {
		return streamSubscriber;
	}
	public void setStreamSubscriber(Stream<PremiumSubscriber> streamSubscriber) {
		this.streamSubscriber = streamSubscriber;
		
	}
	public Predicate<PremiumSubscriber> getPredicate() {
		return predicate;
	}
	public void setPredicate(Predicate<PremiumSubscriber> predicate) {
		this.predicate = predicate;
	}
	public MyR[] getThreadsArrayWorkerTasks() {
		return threadsArrayWorkerTasks;
	}
	public void setThreadsArrayWorkerTasks(MyR[] threadsArrayWorkerTasks) {
		for(int i=0; i<threadsArrayWorkerTasks.length; i++) {
			this.threadsArrayWorkerTasks[i]=threadsArrayWorkerTasks[i];
		}
	}
	
	public void setMatrix(Object[][] matrixInstance) throws Exception{
		
		this.matrix=matrixInstance.clone();
		
	}
	
	public Object[][] getMatrix() {
		if(this.matrix!=null) {
			return matrix;
		}
		return null;
	}
	
	public void displayMatrix() {
		
	}


	public void writeBinary(String file) {
		
		ObjectOutputStream out;
		
		try {
			out= new ObjectOutputStream(new FileOutputStream(file));
			out.writeInt(this.matrix.length);
			out.writeInt(this.matrix[0].length);
			for(int i=0; i<this.matrix.length; i++) {
				for(int j=0; j<this.matrix[0].length; j++) {
					out.writeObject(this.matrix[i][j]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void readBinary(String file) {
		
		ObjectInputStream in;
		
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			int l=in.readInt();
			int c= in.readInt();
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
	
	
	
	
	
	/*
	 * Implementati metoda publica: transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate() 
 *  ce returneaza un obiect de tip List<PremiumSubscriber>
 *  Aceasta metoda transforma/liniarizeaza matricea intr-un obiect din ArrayList<PremiumSubscriber> si apoi, 
 *  sorteaza abonatii si-i filtreaza utilizand ca predicat functii lambda in cadrul 
 *  fluxurile functionale de procesare (functional processing streams).
 *  Aceasta metoda trebuie sa seteze consistent campurile urmatoare din interiorul clasei:
 *  this.streamPassenger, this.listPassengers si this.predicate
 *  si returneaza lista sortata a abonatilor cu un cost de abonamen mai mare decat o limita
 *  abonatii sunt obiecte din clasa PremiumSubscriber
	 * 
	 */
	
	public List<PremiumSubscriber> transformMatrix2VectorAndSortPlusFilterWithLamdaPredicate(float f) {
		
		List<PremiumSubscriber> ls= new ArrayList<PremiumSubscriber>();
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[0].length; j++) {
				ls.add((PremiumSubscriber) this.matrix[i][j]);
			}
		}
		
		this.streamSubscriber=ls.stream().sorted();
		this.predicate=s -> s.getSubscriptionCost()>f;
		this.listSubscribers=this.streamSubscriber.filter(this.predicate).collect(Collectors.<PremiumSubscriber>toList());
		
		return this.listSubscribers;
		
	}
	
	
	
	/*
	 * Implementati metoda calculateAverageSubscriptionCosts() ce returneaza media varstei pasagerilor
 *  Apoi, implementati calculateAverageSubscriptionCostsMultiThreading() ce creaza mai multe fire de executie sau
 *  conlucreaza cu mecanismul Executor-Service pentru crearea de task-uri cu ajutorul campului:
 *  this.threadsArrayWorkerTasks de tip MyR[]
 *  Clasa MyR implementeaza interfata Runnable iar implementare corespunzatoare a clasei MyR => +2 points 
 *  Metoda calculateAverageSubscriptionCostsMultiThreading() calculeaza media de varsta prin utilizarea unui numar 
 *  de "worker tasks" / "threads" - fire de executie egal cu numarul de linii ale matricei.
 *  Aceasta metoda utilizeaza campul: this.threadsArrayWorkerTasks
	 * 
	 */
	
	public float calculateAverageSubscriptionCosts() {
		float s=0;
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[0].length; j++) {
				s+=((PremiumSubscriber)this.matrix[i][j]).getSubscriptionCost();
			}
		}
		
		return s/(this.matrix.length*this.matrix[0].length);
	}
	
	
	public float calculateAverageSubscriptionCostsMultiThreading() {
		
		float s=0;
		final int NRTHREADS=this.matrix.length;
		ExecutorService executorService = Executors.newFixedThreadPool(NRTHREADS);
		this.threadsArrayWorkerTasks= new MyR[NRTHREADS];
		
		for(int i=0; i<NRTHREADS; i++) {
			this.threadsArrayWorkerTasks[i]=new MyR(this.matrix, i);
		}
		
		for(int i=0; i<NRTHREADS; i++) {
			executorService.execute(this.threadsArrayWorkerTasks[i]);
		}
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<NRTHREADS; i++) {
			s+=this.threadsArrayWorkerTasks[i].getAvg();
		}
		
		return s/NRTHREADS;
	}
}